package com.shiyanlou.vhr.config;

import com.shiyanlou.vhr.bean.Menu;
import com.shiyanlou.vhr.bean.Role;
import com.shiyanlou.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 判断当前请求的路径所需要的角色
 * 通过getAttributes方法将访问当前请求路径所需要的 角色 传到 UrlAccessDecisionManager 中
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl=((FilterInvocation)object).getRequestUrl();
        List<Menu> allMenu=menuService.getAllMenu();
        for (Menu menu:allMenu){
            if (antPathMatcher.match(menu.getUrl(),requestUrl) && menu.getRoles().size()>0){
                List<Role> roles=menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i=0;i<size;i++){
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登陆访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
