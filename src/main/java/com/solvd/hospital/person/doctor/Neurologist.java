package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public final class Neurologist extends Doctor {
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + " осматривает пациента " + patient.getFullName() +
                " и выписывает таблетки - Темпалгин");
    }

    public Neurologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
