package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public final class Otorhinolaryngologist extends Doctor {
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + " осматривает ухо, горло, нос пациента " + patient.getFullName() +
                " и выписывает капли - Ципрофарм");
    }

    public Otorhinolaryngologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
