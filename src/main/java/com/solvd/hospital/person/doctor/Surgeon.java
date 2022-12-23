package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Surgeon extends Doctor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Surgeon.class);

    @Override
    public void healPatient(Patient patient) {
        LOGGER.info(getFullName() + " осматривает рентген спины пациента " + patient.getFullName() +
                " и ставит диагноз - Cколиоз 2 степени");
    }

    public Surgeon(String fullName, Specialty specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
