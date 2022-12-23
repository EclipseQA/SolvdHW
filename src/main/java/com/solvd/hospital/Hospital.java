package com.solvd.hospital;


import com.solvd.hospital.department.*;
import com.solvd.hospital.exceptions.InvalidIdHospitalException;
import com.solvd.hospital.person.doctor.*;
import com.solvd.hospital.person.patient.Patient;
import com.solvd.hospital.person.patient.problem.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;

public class Hospital {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hospital.class);
    private String nameOfHospital;
    private final String location = "г.Минск";
    private Integer numberOfPatients;
    private LinkedList<Department> departments;
    private LinkedHashMap<String, String> hospitalOptions;

    public Hospital() {
    }

    public Hospital(String nameOfHospital) {
        setNameOfHospital(nameOfHospital);
    }

    public void getInformationAboutPatient(Patient patient) {
        LOGGER.info(this + patient.toString());
    }

    public void setHospitalOptions() {
        hospitalOptions = new LinkedHashMap<>() {{
            putIfAbsent("1-я городская клиническая больница", location);
            putIfAbsent("2-я городская клиническая больница", location);
            putIfAbsent("3-я городская клиническая больница имени Е.В.Клумова", location);
        }};
    }

    public HashMap<String, String> getHospitalOptions() {
        setHospitalOptions();
        return hospitalOptions;
    }

    public void chooseHospitalOption(Scanner sc) throws InvalidIdHospitalException {
        LOGGER.info("Введите цифру больницы\n" + getHospitalOptions());
        String key = sc.nextLine();
        this.nameOfHospital = getHospitalOptions().keySet().stream().filter(name -> name.contains(key)).findFirst().orElse(null);
        setNumberOfPatients(this.numberOfPatients + 1);
        if (nameOfHospital == null) {
            throw new InvalidIdHospitalException("Неверный ID больницы");
        }
    }

    public Department defineDepartment(Problem problem) {
        setDepartments();
        switch (problem) {
            case SKIN:
                return getDepartments().getFirst();
            case SPINE:
                return getDepartments().stream().filter(p -> p.getDepartmentName().contains("хирургии")).findFirst().get();
            case KIDNEYS:
                return getDepartments().stream().filter(p -> p.getDepartmentName().contains("нефрологии")).findFirst().get();
            case HEAD:
                return getDepartments().stream().filter(p -> p.getDepartmentName().contains("неврологии")).findFirst().get();
            case THROAT:
            case EARS:
            case NOSE:
                return getDepartments().stream().filter(p -> p.getDepartmentName().contains("оториноларингологии")).findFirst().get();
            case TEETH:
                return getDepartments().stream().filter(p -> p.getDepartmentName().contains("стоматологии")).findFirst().get();
            case EYES:
                return getDepartments().getLast();
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
                "УЧРЕЖДЕНИЕ ЗДРАВООХРАНЕНИЯ: " + nameOfHospital + ' ' + getLocation() + "\n";
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

    public LinkedList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments() {
        Random random = new Random(100);
        departments = new LinkedList<>();
        departments.addAll(List.of(
                new EndocrinologyDepartment("Отделение эндокринологии", 5, new ArrayList<>(List.of
                        (new Endocrinologist("Алешин Андрей Егорович", Specialty.Endocrinologist, "9:00-18:00", random.nextInt(419))))),
                (new SurgeryDepartment("Отделение хирургии",
                        10, new ArrayList<>(List.of
                        (new Surgeon("Архипова Елизавета Артёмовна", Specialty.Surgeon, "9:00-18:00", random.nextInt(419)))))),
                new NephrologyDepartment("Отделение нефрологии",
                        10, new ArrayList<>(List.of
                        (new Nephrologist("Баженов Артём Николаевич", Specialty.Nephrologist, "9:00-18:00", random.nextInt(419))))),
                new NeurologyDepartment("Отделение неврологии",
                        10, new ArrayList<>(List.of
                        (new Neurologist("Баранова Валерия Константиновна", Specialty.Neurologist, "9:00-18:00", random.nextInt(419))))),
                new OtorhinolaryngologyDepartment("Отделение оториноларингологии",
                        10, new ArrayList<>(List.of
                        (new Otorhinolaryngologist("Беликов Иван Тимурович", Specialty.Otorhinolaryngologist, "9:00-18:00", random.nextInt(419))))),
                new DentistryDepartment("Отделение стоматологии",
                        10, new ArrayList<>(List.of
                        (new Dentist("Беляев Михаил Александрович", Specialty.Dentist, "9:00-18:00", random.nextInt(419)),
                                new Dentist("Воронина Евгения Ивановна", Specialty.Dentist, "9:00-18:00", random.nextInt(419))))),
                new OphthalmologyDepartment("Отделение офтальмологии",
                        10, new ArrayList<>(List.of(
                        new Ophthalmologist("Березин Егор Николаевич", Specialty.Ophthalmologist, "9:00-18:00", random.nextInt(419)))))));
    }

    public String getLocation() {
        return location;
    }

}