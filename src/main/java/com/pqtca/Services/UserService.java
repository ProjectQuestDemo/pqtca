package com.pqtca.Services;

import com.pqtca.models.User;
import com.pqtca.models.UserWithRoles;
import com.pqtca.repos.UserRepo;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Collections;

@Service
public class UserService {
    private final UserRepo userDao;

    public UserService(UserRepo userDao) {
        this.userDao = userDao;
    }

    public boolean isLoggedIn() {
        boolean isAnonymous = SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return !isAnonymous;
    }

    public User loggedInUser() {
        if(!isLoggedIn()) {
            return null;
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.findOne(user.getId());
    }

    public boolean isOwner(User user){
        if(isLoggedIn()){
            return (user.getUsername().equals(loggedInUser().getUsername()));
        }

        return false;

    }

    public boolean canEditProfile(User user){
        return isLoggedIn() && (user.getId() == loggedInUser().getId());
    }

    public void authenticate(User user) {
        UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }
}
