package com.banksultra.finalproject.security.services;

import com.banksultra.finalproject.mappers.UserMapper;
import com.banksultra.finalproject.models.User;
import com.banksultra.finalproject.repositories.UserRepository;
import com.banksultra.finalproject.security.beans.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userrep;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        User user = userrep.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User NOT Found !"));

        UserPrincipal pr = UserMapper.userToPrincipal(user);

        pr.getAuthorities().stream().map(auth -> auth.getAuthority()).forEach(System.out::println);
        System.out.println(pr.getPassword());

        return UserMapper.userToPrincipal(user);
    }

}
