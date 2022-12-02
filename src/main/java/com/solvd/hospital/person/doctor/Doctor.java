package com.solvd.hospital.person.doctor;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.person.patient.Patient;
import com.solvd.hospital.person.Person;

import java.util.Objects;


public abstract class Doctor extends Person {

    private static Integer NUMBER_OF_DOCTORS = 0;
    private Integer ID = 0;
    private String specialty;
    private String workingHours;
    private Integer officeNumber;
    private Department department;

    public abstract void healPatient(Patient patient);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(ID, doctor.ID) && Objects.equals(specialty, doctor.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, specialty);
    }

    @Override
    public String toString() {
        return "Доктор-" + ID + "{" +
                "ФИО='" + fullName + '\'' +
                ", рабочие часы='" + workingHours + '\'' +
                '}' + "\n";
    }

    public Doctor(String fullName, String specialty, String workingHours, Integer officeNumber) {
        super(fullName);
        NUMBER_OF_DOCTORS++;
        this.ID = getCurrentId();
        this.specialty = specialty;
        this.workingHours = workingHours;
        this.officeNumber = officeNumber;
    }

    private Integer getCurrentId() {
        return NUMBER_OF_DOCTORS;
    }

    public Doctor() {
    }

    public Doctor(String fullName, String specialty, String workingHours, Integer officeNumber, Department department) {
        super(fullName);
        NUMBER_OF_DOCTORS++;
        this.ID = getCurrentId();
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
