package com.solvd.hospital.person.doctor;

public enum Specialty {
    Dentist("Дантист"),
    Endocrinologist("Эндокринолог"),
    Nephrologist("Нефролог"),
    Neurologist("Невролог"),
    Ophthalmologist("Офтальмолог"),
    Otorhinolaryngologist("Otorhinolaryngologist"),
    Surgeon("Хирург");

    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    Specialty(String specialty) {
        this.specialty = specialty;
    }
}
