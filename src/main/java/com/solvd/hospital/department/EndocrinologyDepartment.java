package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;

import java.util.ArrayList;

public final class EndocrinologyDepartment extends Department {

    public EndocrinologyDepartment(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        super(departmentName, numberOfChambers, doctors);
    }

    public EndocrinologyDepartment() {
    }
}
