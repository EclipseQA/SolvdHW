package com.solvd.hospital.person.doctor;

import com.solvd.hospital.person.patient.Patient;

public class Dentist extends Doctor {
    @Override
    public void healPatient(Patient patient) {
        System.out.println(getFullName() + " осматривает зубы пациента " + patient.getFullName() +
                " и советует ему чаще их чистить");
    }

    public Dentist(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName, specialty, workingHours, officeNumber);
    }
}
