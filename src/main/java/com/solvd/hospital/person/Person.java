package com.solvd.hospital.person;

public abstract class Person {

    protected String fullName;
    protected String birthDate;
    protected Character sex;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.split(" ").length == 3) {
            String editedFullName = fullName.replaceAll("\\s+", "");
            for (int i = 0; i < editedFullName.length(); i++) {
                if (!Character.isLetter(editedFullName.charAt(i))) {
                    throw new IllegalArgumentException("Неверные формат ФИО");
                }
            }
            this.fullName = fullName;
        } else {
            throw new IllegalArgumentException("Неверные формат ФИО");
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.split("\\.").length == 3) {
            String editedBirthDate = birthDate.replaceAll("\\.", "");
            for (int i = 0; i < editedBirthDate.length(); i++) {
                if (!Character.isDigit(editedBirthDate.charAt(i))) {
                    throw new IllegalArgumentException("Неверные формат даты");
                }
                this.birthDate = birthDate;
            }
        } else {
            throw new IllegalArgumentException("Неверные формат даты");
        }
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        if (sex != 'м'
        && sex != 'ж') {
            throw new IllegalArgumentException("Неверные формат пола");
        }
        this.sex = sex;
    }

    public Person(String fullName, String birthDate, Character sex) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public Person() {

    }
}
