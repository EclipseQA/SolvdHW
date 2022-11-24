package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public class Ophthalmologist extends Doctor{
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + " осматривает глаза пациента " + patient.getFullName() +
                " и ставит диагноз - Близорукость");
    }

    public Ophthalmologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}

