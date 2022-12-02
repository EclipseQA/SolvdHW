package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public final class Surgeon extends Doctor {
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + " осматривает рентген спины пациента " + patient.getFullName() +
                " и ставит диагноз - Cколиоз 2 степени");
    }

    public Surgeon(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
