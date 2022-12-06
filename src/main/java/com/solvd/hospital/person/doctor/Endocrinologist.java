package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Endocrinologist extends Doctor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Endocrinologist.class);
    @Override
    public void healPatient(Patient patient) {
        LOGGER.info(getFullName() + " осматривает кожу пациента "
                + patient.getFullName() + " и выписывает витамины(A, B, C)");
    }

    public Endocrinologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
