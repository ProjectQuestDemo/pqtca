package com.pqtca.Services;

import com.pqtca.models.User;
import com.pqtca.models.UserWithRoles;
import com.pqtca.repos.UserRepo;
import com.pqtca.repos.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepo userDao;
    private final UserRoles roles;

    @Autowired
    public UserDetailsLoader(UserRepo userDao, UserRoles roles) {
        this.userDao = userDao;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }
        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }
}