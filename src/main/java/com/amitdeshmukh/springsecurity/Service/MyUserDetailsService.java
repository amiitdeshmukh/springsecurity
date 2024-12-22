package com.amitdeshmukh.springsecurity.Service;

import com.amitdeshmukh.springsecurity.Repository.UserRepo;
import com.amitdeshmukh.springsecurity.entity.User;
import com.amitdeshmukh.springsecurity.entity.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }


        return new UserPrinciple(user);
    }
}
