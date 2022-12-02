package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;

import java.util.ArrayList;

public final class DentistryDepartment extends Department {

    public DentistryDepartment() {
    }

    public DentistryDepartment(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        super(departmentName, numberOfChambers, doctors);
    }
}
