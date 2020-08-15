package com.suyz.resource.config;

import com.suyz.resource.mapper.TbPermissionMapper;
import com.suyz.resource.model.TbPermission;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author suyz
 * @date 2020/8/15 22:10
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private TbPermissionMapper permissionMapper;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        final List<TbPermission> permissions = permissionMapper.selectAll();
        final ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.exceptionHandling()
                .and()
                .authorizeRequests();
        permissions.forEach(v -> {
            registry.antMatchers(v.getUrl()).hasAuthority(v.getEnname());
        });
    }
}
