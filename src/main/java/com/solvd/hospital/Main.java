package com.solvd.hospital;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.patient.Patient;

import java.util.Scanner;


public class Main {
    private static Patient patient;
    private static Hospital hospital;
    private static Doctor doctor;
    private static Department department;

    public static void main(String[] args) {
        hospital = new Hospital("Первая городская больница", "г.Минск");
        patient = new Patient();

        try (Scanner scanner = new Scanner(System.in)) {
            patient.fillOutPatientInformation(scanner);
            patient.complainsAbout(scanner);
            department = hospital.defineDepartment(patient.getProblem());
            doctor = department.chooseDoctor(scanner, patient);
        }
        hospital.getInformationAboutPatient(hospital, patient);
        doctor.healPatient(patient);
    }
}