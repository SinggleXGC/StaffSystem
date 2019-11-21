package com.shiyanlou.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiyanlou.vhr.bean.RespBean;
import com.shiyanlou.vhr.common.HrUtils;
import com.shiyanlou.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 对web请求的一些简单的设置
 */
@Configuration
/**
 * Spring Security默认是禁止注解的，要想开启注解，需要在继承
 * WebSecurityConfigurerAdapter类上加@EnableGlobalMethodSecurity注解，
 * 来判断用户对某个控制层的方法是否具有访问权限
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html","/static/**","/login_p","/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //将UrlAccessDecisionManager、CustomMetadataSource注入进来。
                //到时候请求都会经过刚才的过滤器（参数o）
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        o.setSecurityMetadataSource(metadataSource);
                        return o;
                    }
                })
                //返回HttpSecurity对象
                .and()
                //登录处理
                .formLogin().loginPage("/login_P").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                //验证失败处理
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        RespBean respBean = null;
                        if (e instanceof BadCredentialsException || e instanceof UsernameNotFoundException) {
                            respBean = RespBean.error("账户名或者密码输入错误!");
                        } else if (e instanceof LockedException) {
                            respBean = RespBean.error("账户被锁定，请联系管理员!");
                        } else if (e instanceof CredentialsExpiredException) {
                            respBean = RespBean.error("密码过期，请联系管理员!");
                        } else if (e instanceof AccountExpiredException) {
                            respBean = RespBean.error("账户过期，请联系管理员!");
                        } else if (e instanceof DisabledException) {
                            respBean = RespBean.error("账户被禁用，请联系管理员!");
                        } else {
                            respBean = RespBean.error("登录失败!");
                        }
                        response.setStatus(401);
                        ObjectMapper objectMapper = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(objectMapper.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.ok("登陆成功", HrUtils.getCurrentHr());
                        PrintWriter out = response.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                //登出处理
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.ok("注销成功");
                        ObjectMapper objectMapper = new ObjectMapper();
                        PrintWriter printWriter = response.getWriter();
                        printWriter.write(objectMapper.writeValueAsString(respBean));
                        printWriter.flush();
                        printWriter.close();
                    }
                })
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }
}
