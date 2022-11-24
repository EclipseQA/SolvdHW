package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public class Nephrologist extends Doctor {
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + "осматривает пациента " + patient.getFullName()
                + " и ставит диагноз - Гидронефроз");
    }

    public Nephrologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
