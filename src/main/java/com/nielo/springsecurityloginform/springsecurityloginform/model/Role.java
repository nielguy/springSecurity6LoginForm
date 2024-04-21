package com.nielo.springsecurityloginform.springsecurityloginform.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Document(collection = "role")
public class Role {

    @Id
    private String id;
    private String name;

//    public Role() {
//        this.id = UUID.randomUUID().toString();
//    }

    public Role(String name) {
        this.name=name;
    }
}
