package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Dentist extends Doctor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dentist.class);
    @Override
    public void healPatient(Patient patient) {
        LOGGER.info(getFullName() + " осматривает зубы пациента " + patient.getFullName() +
                " и советует ему чаще их чистить");
    }

    public Dentist(String fullName, Specialty specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
