package com.solvd.hospital.person.patient;

import com.solvd.hospital.exceptions.InvalidBirthDateStatementException;
import com.solvd.hospital.exceptions.InvalidNameStatementException;
import com.solvd.hospital.exceptions.InvalidProblemException;
import com.solvd.hospital.exceptions.InvalidSexArgumentException;
import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.Person;
import com.solvd.hospital.person.patient.problem.Problem;
import org.slf4j.*;

import java.util.Objects;
import java.util.Scanner;

public final class Patient extends Person {
    private final static Logger LOGGER = LoggerFactory.getLogger(Patient.class);
    private String address;
    private Doctor doctorToExamine;
    private String timeToCome;
    private Problem problem;


    public void complainsAbout(Scanner sc) {
        System.out.println("Введите из списка на что у вас жалоба: ");

        for (Problem potentialProblem : Problem.values()) {
            int i = potentialProblem.ordinal() + 1;
            System.out.println(i + ". " + potentialProblem.getProblem());
        }

        String problem = sc.nextLine();
        try {
            setProblem(Problem.findByName(problem));
        } catch (InvalidProblemException e) {
            LOGGER.info(e.toString(), problem);
            System.out.println("Попробуйте еще раз");
            complainsAbout(sc);
        }
    }

    public void fillOutPatientInformation(Scanner sc) throws Exception {
        System.out.println("Здравствуйте! Для того, чтобы записаться к врачу введите ваше ФИО: ");
        try {
            setFullName(sc);
        } catch (InvalidNameStatementException e) {
            LOGGER.debug(e.toString());
            System.out.println("Введите данные снова");
            setFullName(sc);
        }

        System.out.println("Дата рождения: ");
        try {
            setBirthDate(sc);
        } catch (InvalidBirthDateStatementException e) {
            LOGGER.debug(e.toString());
            System.out.println("Введите данные снова");
            setBirthDate(sc);
        }

        System.out.println("Ваш пол(ж/м): ");
        try {
            setSex(sc);
        } catch (InvalidSexArgumentException e) {
            LOGGER.debug(e.toString());
            System.out.println("Введите данные снова");
            setSex(sc);
        }

        System.out.println("Адрес проживания: ");
        setAddress(sc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(address, patient.address) && Objects.equals(doctorToExamine, patient.doctorToExamine) && Objects.equals(problem, patient.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, doctorToExamine, problem);
    }

    @Override
    public String toString() {
        return "Пациент: " + fullName + "\n" +
                "Жалобы: " + problem + '\n' +
                doctorToExamine.getSpecialty() + ": " + doctorToExamine.getFullName() + '\n' +
                "Время приема: " + timeToCome + '\n' +
                "Кабинет: " + doctorToExamine.getOfficeNumber() + '\n' +
                "--------------------------------------";
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

    public void setAddress(Scanner sc) {
        this.address = sc.nextLine();
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

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
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
