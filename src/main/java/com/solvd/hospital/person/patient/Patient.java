package com.solvd.hospital.person.patient;

import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.Person;

import java.util.Scanner;

public class Patient extends Person {

    private final String exampleOfComplains = "кожа, позвоночник, почки, голова, горло, ухи, нос, зубы, глаза";
    private String address;
    private Doctor doctorToExamine;
    private String timeToCome;
    private String problem;



    public void complainsAbout(Scanner sc) {
        System.out.println("Введите из списка на что у вас жалоба: " + exampleOfComplains);
        String problem = sc.nextLine();
        if (!exampleOfComplains.contains(problem)) {
            throw new IllegalArgumentException("У нас тут от такого не лечат");
        }
        setProblem(problem);
    }

    public void fillOutPatientInformation(Scanner sc) {
        System.out.println("Здравствуйте! Для того, чтобы записаться к врачу введите ваше ФИО: ");
        setFullName(sc.nextLine());

        System.out.println("Дата рождения: ");
        setBirthDate(sc.nextLine());

        System.out.println("Ваш пол(ж/м): ");
        setSex(sc.nextLine().charAt(0));

        System.out.println("Адрес проживания: ");
        setAddress(sc.nextLine());
    }

    public Patient(String fullName, String birthDate, Character sex) {
        super(fullName, birthDate, sex);
    }

    public Patient() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor getDoctorToExamine() {
        return doctorToExamine;
    }

    public void setNameOfDoctorToExamine(Doctor doctorToExamine) {
        this.doctorToExamine = doctorToExamine;
    }

    public String getTimeToCome() {
        return timeToCome;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setTimeToCome(String timeToCome) {
        this.timeToCome = timeToCome;
    }

    public Patient(String fullName, String birthDate, Character sex, String address, Doctor doctorToExamine, String timeToCome) {
        super(fullName, birthDate, sex);
        this.address = address;
        this.doctorToExamine = doctorToExamine;
        this.timeToCome = timeToCome;
    }
}
