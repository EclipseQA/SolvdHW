package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;

import java.util.ArrayList;


public final class OtorhinolaryngologyDepartment extends Department {

    public OtorhinolaryngologyDepartment() {
    }

    public OtorhinolaryngologyDepartment(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        super(departmentName, numberOfChambers, doctors);
    }
}
