package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Otorhinolaryngologist extends Doctor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Otorhinolaryngologist.class);
    @Override
    public void healPatient(Patient patient) {
        LOGGER.info(getFullName() + " осматривает ухо, горло, нос пациента " + patient.getFullName() +
                " и выписывает капли - Ципрофарм");
    }

    public Otorhinolaryngologist(String fullName, Specialty specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
