package com.medicare.Medicare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float rating=0.0F;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User userId;

    @OneToMany
    private List<Specialization> specializationList; // this should be many to many , validate it !

    @OneToMany
    private List<Qualification> qualificationList; // this should be many to many , validate it !

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
