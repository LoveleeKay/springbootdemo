package com.example.springbootdemo.security;

import com.example.springbootdemo.dao.SysPermissionDao;
import com.example.springbootdemo.dao.SysUserDao;
import com.example.springbootdemo.security.po.SysPermission;
import com.example.springbootdemo.security.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//自定义userdetailservice
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysPermissionDao sysPermissionDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.selectByName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (sysUser != null) {
            System.err.println("sysUser===============" + sysUser);
            //获取用户的授权
            List<SysPermission> permissions = sysPermissionDao.selectByUserId(sysUser.getId());
            //声明授权文件
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
        }
        System.err.println("grantedAuthorities===============" + grantedAuthorities);
        return new User(sysUser.getName(), sysUser.getPassword(), grantedAuthorities);
    }
}
