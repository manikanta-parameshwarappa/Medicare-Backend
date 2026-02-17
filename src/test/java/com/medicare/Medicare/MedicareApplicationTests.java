package com.medicare.Medicare;

import com.medicare.Medicare.entity.Doctor;
import com.medicare.Medicare.entity.Patient;
import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.enums.UserRole;
import com.medicare.Medicare.repository.DoctorRepository;
import com.medicare.Medicare.repository.PatientRepository;
import com.medicare.Medicare.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicareApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testEntity(){
        User user1 = User.builder()
                .name("Patient 1")
                .email("patient1@gamil.com")
                .passwordHash("password")
                .role(UserRole.PATIENT)
                .build();

        userRepository.save(user1);

        User user2 = User.builder()
                .name("Doctor 1")
                .email("doctor1@gamil.com")
                .passwordHash("password")
                .role(UserRole.DOCTOR)
                .build();

        userRepository.save(user2);

        Patient patient = Patient.builder().build();
        patient.setUserId(user1);

        patientRepository.save(patient);

        Doctor doctor = Doctor.builder().build();
        doctor.setUserId(user2);

        doctorRepository.save(doctor);

//        userRepository.deleteAll();
    }

}
