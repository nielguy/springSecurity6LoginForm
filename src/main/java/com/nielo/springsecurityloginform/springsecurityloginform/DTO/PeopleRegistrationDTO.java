package com.nielo.springsecurityloginform.springsecurityloginform.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PeopleRegistrationDTO {

    private String name;
    private String email;
    private String password;
}
