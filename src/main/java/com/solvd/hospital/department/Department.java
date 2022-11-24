package com.solvd.hospital.department;

import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.patient.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Department {
    protected String departmentName;
    protected Integer numberOfChambers;
    protected ArrayList<Doctor> doctors;

    public Department() {
    }

    public Doctor chooseDoctor(Scanner sc, Patient patient) {
        System.out.println("Введите ID доктора, к которому вы хотите попасть");
        System.out.println(getDoctors() + ": ");
        Integer id = Integer.parseInt(sc.nextLine())-1;

        System.out.println("Введите время, которое удобно для Вас");
        patient.setTimeToCome(sc.nextLine());

        Doctor doctor = getDoctors().get(id);
        patient.setNameOfDoctorToExamine(doctor);

        return doctor;
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
