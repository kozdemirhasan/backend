package com.kozdemir.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String fistName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    public User(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }
}
