package com.solvd.hospital;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.exceptions.InvalidDoctorsIDException;
import com.solvd.hospital.exceptions.InvalidIdHospitalException;
import com.solvd.hospital.person.doctor.Doctor;
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
        Doctor doctor;

        try (Scanner scanner = new Scanner(System.in)) {
            hospital = new Hospital();
            patient = new Patient();
            hospital.chooseHospitalOption(scanner);
            patient.fillOutPatientInformation(scanner);
            patient.complainsAbout(scanner);

            department = hospital.defineDepartment(patient.getProblem());
            doctor = department.chooseDoctor(scanner, patient);
            patient.setNameOfDoctorToExamine(doctor);

            hospital.getInformationAboutPatient(patient);
            patient.getDoctorToExamine().healPatient(patient);
        } catch (InvalidDoctorsIDException | InvalidIdHospitalException e) {
            LOGGER.error(e + "Прекращение работы программы");
        }
    }
}