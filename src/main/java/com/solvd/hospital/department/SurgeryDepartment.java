package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;

import java.util.ArrayList;

public final class SurgeryDepartment extends Department {

    public SurgeryDepartment() {
    }

    public SurgeryDepartment(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        super(departmentName, numberOfChambers, doctors);
    }
}
