package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Ophthalmologist extends Doctor{
    private static final Logger LOGGER = LoggerFactory.getLogger(Ophthalmologist.class);

    @Override
    public void healPatient(Patient patient) {
        LOGGER.info(getFullName() + " осматривает глаза пациента " + patient.getFullName() +
                " и ставит диагноз - Близорукость");
    }

    public Ophthalmologist(String fullName, Specialty specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}

