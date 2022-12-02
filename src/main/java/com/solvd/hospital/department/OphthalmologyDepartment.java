package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;

import java.util.ArrayList;

public final class OphthalmologyDepartment extends Department {

    public OphthalmologyDepartment() {
    }


    public OphthalmologyDepartment(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        super(departmentName, numberOfChambers, doctors);
    }
}
