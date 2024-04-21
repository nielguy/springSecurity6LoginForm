package com.nielo.springsecurityloginform.springsecurityloginform.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
}
