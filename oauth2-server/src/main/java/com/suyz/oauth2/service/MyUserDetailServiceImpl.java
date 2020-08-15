package com.suyz.oauth2.service;

import com.suyz.oauth2.mapper.TbPermissionMapper;
import com.suyz.oauth2.mapper.TbUserMapper;
import com.suyz.oauth2.model.TbPermission;
import com.suyz.oauth2.model.TbUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author suyz
 * @date 2020/8/15 19:16
 */
@Service(value = "myUserDetailService")
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Example example = new Example.Builder(TbUser.class).build();
        example.createCriteria().andEqualTo("username", username);
        final TbUser user = tbUserMapper.selectOneByExample(example);
        List<GrantedAuthority> list = new ArrayList<>();
        if (Objects.nonNull(user)) {
            final List<TbPermission> permissions = tbPermissionMapper.selectPermissionByUserId(user.getId());
            if (!CollectionUtils.isEmpty(permissions)) {
                permissions.forEach(v -> list.add(new SimpleGrantedAuthority(v.getEnname())));
            }
        }
        return new User(user.getUsername(), user.getPassword(), list);

    }
}
