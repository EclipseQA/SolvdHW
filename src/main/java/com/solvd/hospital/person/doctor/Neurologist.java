package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Neurologist extends Doctor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Neurologist.class);

    @Override
    public void healPatient(Patient patient) {
        LOGGER.info(getFullName() + " осматривает пациента " + patient.getFullName() +
                " и выписывает таблетки - Темпалгин");
    }

    public Neurologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
