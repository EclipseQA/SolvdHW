package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public final class Endocrinologist extends Doctor {
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + " осматривает кожу пациента "
                + patient.getFullName() + " и выписывает витамины(A, B, C)");
    }

    public Endocrinologist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
