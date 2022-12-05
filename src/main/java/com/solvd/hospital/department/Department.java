package com.solvd.hospital.department;

import com.solvd.hospital.exceptions.InvalidDoctorsIDException;
import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.patient.Patient;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class Department {
    protected String departmentName;
    protected Integer numberOfChambers;
    protected ArrayList<Doctor> doctors;

    public Department() {
    }

    public final Doctor chooseDoctor(Scanner sc, Patient patient) throws InvalidDoctorsIDException {
        System.out.println("Введите ID доктора, к которому вы хотите попасть");
        System.out.println(getDoctors() + ": ");
        Integer id = Integer.parseInt(sc.nextLine()) - 1;
        if (getDoctors().size() - 1 < id) {
            throw new InvalidDoctorsIDException("Doctor's ID is invalid");
        }
        System.out.println("Введите время, которое удобно для Вас");
        patient.setTimeToCome(sc.nextLine());

        Doctor doctor = getDoctors().get(id);
        patient.setNameOfDoctorToExamine(doctor);

        return doctor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) && Objects.equals(numberOfChambers, that.numberOfChambers) && Objects.equals(doctors, that.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, numberOfChambers, doctors);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }

    public Department(String departmentName, Integer numberOfChambers, ArrayList<Doctor> doctors) {
        this.departmentName = departmentName;
        this.numberOfChambers = numberOfChambers;
        this.doctors = doctors;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getNumberOfChambers() {
        return numberOfChambers;
    }

    public void setNumberOfChambers(Integer numberOfChambers) {
        this.numberOfChambers = numberOfChambers;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }
}
