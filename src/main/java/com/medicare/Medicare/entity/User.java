package com.medicare.Medicare.entity;
import com.medicare.Medicare.enums.BloodGroup;
import com.medicare.Medicare.enums.Gender;
import com.medicare.Medicare.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private Integer PhoneNumber;


    private Gender gender;


    private BloodGroup bloodGroup;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private UserRole role = UserRole.PATIENT;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList;
}
