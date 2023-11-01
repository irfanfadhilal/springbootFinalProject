package com.banksultra.finalproject.mappers;

import com.banksultra.finalproject.dto.UserDto;
import com.banksultra.finalproject.models.User;
import com.banksultra.finalproject.security.beans.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;
public class UserMapper {
    public static UserPrincipal userToPrincipal(User user){

        List<SimpleGrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());

        return new UserPrincipal()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setEnabled(true)
                .setAuthorities(authorities);
    }

    public UserDto userMapDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirst_name(user.getFirst_name());
        userDto.setLast_name(user.getLast_name());
        userDto.setMobile_number(user.getMobile_number());

        return userDto;
    }
}
