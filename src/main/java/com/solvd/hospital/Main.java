package com.solvd.hospital;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.exceptions.InvalidDoctorsIDException;
import com.solvd.hospital.person.patient.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Patient patient;
        Hospital hospital;
        Department department;
        Scanner scanner = new Scanner(System.in);

        hospital = new Hospital("Первая городская больница");
        patient = new Patient();

        try {
            patient.fillOutPatientInformation(scanner);
            patient.complainsAbout(scanner);
            department = hospital.defineDepartment(patient.getProblem());

            patient.setNameOfDoctorToExamine(department.chooseDoctor(scanner, patient));
        } catch (InvalidDoctorsIDException e) {
            LOGGER.debug(e.toString());
        } finally {
            scanner.close();
        }
        hospital.getInformationAboutPatient(patient);
        patient.getDoctorToExamine().healPatient(patient);
    }
}