package com.solvd.hospital;


import com.solvd.hospital.department.*;
import com.solvd.hospital.person.doctor.*;
import com.solvd.hospital.person.patient.Patient;
import com.solvd.hospital.person.patient.problem.Problem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Hospital {

    private String nameOfHospital;
    private final String location = "г.Минск";
    private Integer numberOfPatients;
    private ArrayList<Department> departments;

    public Hospital() {
    }

    public Hospital(String nameOfHospital) {
        setNameOfHospital(nameOfHospital);
    }

    public void getInformationAboutPatient(Patient patient) {
        System.out.println(this + patient.toString());
    }

    public Department defineDepartment(Problem problem) {
        Random random = new Random(100);
        switch (problem) {
            case SKIN:
                return new EndocrinologyDepartment("Отделение эндокринологии",
                        5, new ArrayList<>(Arrays.asList
                        (new Endocrinologist("Алешин Андрей Егорович", "Эндокринолог", "9:00-18:00", random.nextInt(419)))));
            case SPINE:
                return new SurgeryDepartment("Отделение хирургии",
                        10, new ArrayList<>(Arrays.asList
                        (new Surgeon("Архипова Елизавета Артёмовна", "Хирург", "9:00-18:00", random.nextInt(419)))));
            case KIDNEYS:
                return new NephrologyDepartment("Отделение нефрологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Nephrologist("Баженов Артём Николаевич", "Нефролог", "9:00-18:00", random.nextInt(419)))));
            case HEAD:
                return new NeurologyDepartment("Отделение неврологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Neurologist("Баранова Валерия Константиновна", "Невролог", "9:00-18:00", random.nextInt(419)))));
            case THROAT:
            case EARS:
            case NOSE:
                return new OtorhinolaryngologyDepartment("Отделение оториноларингологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Otorhinolaryngologist("Беликов Иван Тимурович", "Оториноларинголог", "9:00-18:00", random.nextInt(419)))));
            case TEETH:
                return new DentistryDepartment("Отделение стоматологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Dentist("Беляев Михаил Александрович", "Стоматолог-стажер", "9:00-18:00", random.nextInt(419)),
                                new Dentist("Воронина Евгения Ивановна", "Стоматолог", "9:00-18:00", random.nextInt(419)))));
            case EYES:
                return new OphthalmologyDepartment("Отделение офтальмологии",
                        10, new ArrayList<>(Arrays.asList
                        (new Ophthalmologist("Березин Егор Николаевич", "Офтальмолог", "9:00-18:00", random.nextInt(419)))));
            default:
                throw new IllegalArgumentException("Ни чем помочь не можем");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(nameOfHospital, hospital.nameOfHospital) && Objects.equals(departments, hospital.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfHospital, departments);
    }

    @Override
    public String toString() {
        return "--------------------------------------" + "\n" +
                "УЧРЕЖДЕНИЕ ЗДРАВООХРАНЕНИЯ: " + nameOfHospital + ' ' + location + "\n";
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

}