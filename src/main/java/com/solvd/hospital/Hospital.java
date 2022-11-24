package com.solvd.hospital;


import com.solvd.hospital.department.*;
import com.solvd.hospital.person.doctor.*;
import com.solvd.hospital.person.patient.Patient;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Hospital {

    private String nameOfHospital;
    private String location;
    private Integer numberOfPatients;
    private ArrayList<Department> departments;

    public Hospital() {
    }

    public Hospital(String nameOfHospital, String location) {
        setLocation(location);
        setNameOfHospital(nameOfHospital);
    }


    public void getInformationAboutPatient(Hospital hospital, Patient patient) {
        System.out.println("--------------------------------------" + "\n" +
                hospital.getNameOfHospital() + " " + hospital.getLocation() + "\n" +
                "Пациент: " + patient.getFullName() + "\n" +
                "Жалобы: " + patient.getProblem() + "\n" +
                patient.getDoctorToExamine().getSpecialty() + ": " + patient.getDoctorToExamine().getFullName() + "\n" +
                "Время приема: " + patient.getTimeToCome() + "\n" +
                "Кабинет: " + patient.getDoctorToExamine().getOfficeNumber() + "\n" +
                "--------------------------------------");
    }

    public Department defineDepartment(String problem) {
        Random random = new Random(100);
        switch (problem) {
            case "кожа":
                return new EndocrinologyDepartment("Отделение эндокринологии",
                        5, new ArrayList<>(Arrays.asList
                        (new Endocrinologist("Алешин Андрей Егорович", "Эндокринолог", "9:00-18:00", random.nextInt(419)))));
            case "позвоночник":
                return new SurgeryDepartment("Отделение хирургии",
                        10, new ArrayList<>(Arrays.asList
                        (new Surgeon("Архипова Елизавета Артёмовна", "Хирург", "9:00-18:00", random.nextInt(419)))));
            case "почки":
                return new NephrologyDepartment("Отделение нефрологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Nephrologist("Баженов Артём Николаевич", "Нефролог", "9:00-18:00", random.nextInt(419)))));
            case "голова":
                return new NeurologyDepartment("Отделение неврологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Neurologist("Баранова Валерия Константиновна", "Невролог", "9:00-18:00", random.nextInt(419)))));
            case "горло":
            case "ухи":
            case "нос":
                return new OtorhinolaryngologyDepartment("Отделение оториноларингологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Otorhinolaryngologist("Беликов Иван Тимурович", "Оториноларинголог", "9:00-18:00", random.nextInt(419)))));
            case "зубы":
                return new DentistryDepartment("Отделение стоматологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Dentist("Беляев Михаил Александрович", "Стоматолог-стажер", "9:00-18:00", random.nextInt(419)),
                                new Dentist("Воронина Евгения Ивановна", "Стоматолог", "9:00-18:00", random.nextInt(419)))));
            case "глаза":
                return new OphthalmologyDepartment("Отделение офтальмологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Ophthalmologist("Березин Егор Николаевич", "Офтальмолог", "9:00-18:00", random.nextInt(419)))));
            default:
                throw new IllegalArgumentException("Ни чем помочь не можем");
        }
    }

    public Hospital(String nameOfHospital) {
        this.nameOfHospital = nameOfHospital;
    }

    public String getNameOfHospital() {
        return nameOfHospital;
    }

    public void setNameOfHospital(String nameOfHospital) {
        this.nameOfHospital = nameOfHospital;
    }

    public Integer getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(Integer numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public final ArrayList<Department> getDepartments() {
        return new ArrayList<>(Arrays.asList(new OphthalmologyDepartment(),
                new DentistryDepartment()));
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}