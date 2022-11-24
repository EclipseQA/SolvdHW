package com.solvd.hospital.person.doctor;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.person.patient.Patient;
import com.solvd.hospital.person.Person;


public abstract class Doctor extends Person {

    private String specialty;
    private String workingHours;
    private Integer officeNumber;
    private Department department;

    public abstract void healPatient(Patient patient);

    @Override
    public String toString() {
        return "Доктор{" +
                "ФИО='" + fullName + '\'' +
                ", рабочие часы='" + workingHours + '\'' +
                '}' + "\n";
    }

    public Doctor(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName);
        this.specialty = specialty;
        this.workingHours = workingHours;
        this.officeNumber = officeNumber;
    }

    public Doctor() {
    }

    public Doctor(String fullName, String specialty, String workingHours, Integer officeNumber, Department department) {
        super(fullName);
        this.specialty = specialty;
        this.workingHours = workingHours;
        this.officeNumber = officeNumber;
        this.department = department;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public Integer getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(Integer officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
