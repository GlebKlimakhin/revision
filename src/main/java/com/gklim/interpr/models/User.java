package com.gklim.interpr.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastname;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;
}
