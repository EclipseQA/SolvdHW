package com.solvd.hospital.person;

import java.util.Objects;
import java.util.Scanner;

public abstract class Person {

    protected String fullName;
    protected String birthDate;
    protected Character sex;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(Scanner sc) {
        String fullName = sc.nextLine();
        if (fullName.split(" ").length == 3) {
            String editedFullName = fullName.replaceAll("\\s+", "");
            for (int i = 0; i < editedFullName.length(); i++) {
                if (!Character.isLetter(editedFullName.charAt(i))) {
                    System.err.println("Неверные формат ФИО");
                    setFullName(sc);
                }
            }
            this.fullName = fullName;
        } else {
            System.err.println("Неверные формат ФИО");
            setFullName(sc);
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Scanner sc) {
        String birthDate = sc.nextLine();
        if (birthDate.split("\\.").length == 3) {
            String editedBirthDate = birthDate.replaceAll("\\.", "");
            for (int i = 0; i < editedBirthDate.length(); i++) {
                if (!Character.isDigit(editedBirthDate.charAt(i))) {
                    System.err.println("Неверные формат даты");
                    setBirthDate(sc);
                }
                this.birthDate = birthDate;
            }
        } else {
            System.err.println("Неверные формат даты");
            setBirthDate(sc);
        }
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Scanner sc) {
        Character sex = sc.nextLine().charAt(0);
        if (sex != 'м'
                && sex != 'ж') {
            System.err.println("Неверные формат пола");
            setSex(sc);
        }
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fullName, person.fullName) && Objects.equals(birthDate, person.birthDate) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthDate, sex);
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
