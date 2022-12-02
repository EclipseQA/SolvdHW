package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;

import java.util.ArrayList;

public final class NephrologyDepartment extends Department {

    public NephrologyDepartment() {
    }

    public NephrologyDepartment(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        super(departmentName, numberOfChambers, doctors);
    }
}
