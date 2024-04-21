package com.nielo.springsecurityloginform.springsecurityloginform.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "people")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class People {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;
//    @DBRef
    private List<Role> roles;

//    public People() {
//        this.id = UUID.randomUUID().toString();
//    }

//    public <T> People(String name, String email, String password, List<T> user) {}
}
