package com.example.demo.models;

import com.example.demo.enums.UserStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String lastname;
    private String firstname;
    private String username;
    private String email;
    private String password;
    private UserStatus userStatus;
}
