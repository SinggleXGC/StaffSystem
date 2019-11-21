package com.shiyanlou.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 这里是最后做访问控制的地方
 * CustomMetadataSource传来的 角色 列表，与当前用户拥有的 角色 做比较，
 * 若拥有权限就进行访问，否则抛出异常。
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()){
            ConfigAttribute configAttribute=iterator.next();
            //当前请求需要的权限
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)){
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw  new BadCredentialsException("未登录");
                }else
                    return;
            }
            //当前用户具有的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority:authorities){
                if (authority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
