package com.medicare.Medicare;

import com.medicare.Medicare.entity.Qualification;
import com.medicare.Medicare.entity.Specialization;
import com.medicare.Medicare.repository.QualificationRepository;
import com.medicare.Medicare.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataSeeder implements CommandLineRunner {

    private final QualificationRepository qualificationRepo;
    private final SpecializationRepository specializationRepo;

    public DataSeeder(QualificationRepository qualificationRepo,
                      SpecializationRepository specializationRepo) {
        this.qualificationRepo = qualificationRepo;
        this.specializationRepo = specializationRepo;
    }

    @Override
    public void run(String... args) {
        seedQualifications();
        seedSpecializations();
    }

    private void seedQualifications() {
        if (qualificationRepo.count() == 0) {
            List<String> degrees = List.of(
                    "MBBS", "MD", "MS", "DM", "MCh",
                    "BDS", "MDS", "B.Sc Nursing", "M.Sc Nursing", "PhD in Medicine",
                    "Bachelor of Pharmacy", "Doctor of Pharmacy", "Bachelor of Physiotherapy",
                    "Master of Physiotherapy", "Bachelor of Occupational Therapy",
                    "Master of Occupational Therapy", "Bachelor of Veterinary Science",
                    "MD Pediatrics", "MD Dermatology", "MD Psychiatry"
            );

            List<Qualification> qualifications = degrees.stream()
                    .map(name -> {
                        Qualification q = new Qualification();
                        q.setDegreeName(name);
                        return q;
                    })
                    .toList();

            qualificationRepo.saveAll(qualifications);
        }
    }

    private void seedSpecializations() {
        if (specializationRepo.count() == 0) {
            Map<String, String> specs = Map.ofEntries(
                    Map.entry("Cardiology", "Heart and cardiovascular system"),
                    Map.entry("Neurology", "Brain and nervous system"),
                    Map.entry("Orthopedics", "Bones and musculoskeletal system"),
                    Map.entry("Dermatology", "Skin, hair, and nails"),
                    Map.entry("Pediatrics", "Child health and development"),
                    Map.entry("Psychiatry", "Mental health and disorders"),
                    Map.entry("Oncology", "Cancer diagnosis and treatment"),
                    Map.entry("Radiology", "Medical imaging and diagnostics"),
                    Map.entry("Anesthesiology", "Anesthesia and perioperative care"),
                    Map.entry("Gastroenterology", "Digestive system and liver"),
                    Map.entry("Endocrinology", "Hormones and metabolic disorders"),
                    Map.entry("Nephrology", "Kidney and urinary system"),
                    Map.entry("Pulmonology", "Lungs and respiratory system"),
                    Map.entry("Hematology", "Blood and related disorders"),
                    Map.entry("Rheumatology", "Autoimmune and joint diseases"),
                    Map.entry("Obstetrics & Gynecology", "Women’s reproductive health"),
                    Map.entry("General Surgery", "Surgical procedures across systems"),
                    Map.entry("Plastic Surgery", "Reconstructive and cosmetic surgery"),
                    Map.entry("Urology", "Urinary tract and male reproductive system"),
                    Map.entry("Ophthalmology", "Eye and vision care")
            );

            List<Specialization> specializations = specs.entrySet().stream()
                    .map(entry -> {
                        Specialization s = new Specialization();
                        s.setTitle(entry.getKey());
                        s.setDescription(entry.getValue());
                        return s;
                    })
                    .toList();

            specializationRepo.saveAll(specializations);
        }
    }
}
