package com.banksultra.finalproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String mobile_number;
}
