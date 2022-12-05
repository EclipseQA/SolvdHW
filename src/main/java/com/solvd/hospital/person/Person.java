package com.solvd.hospital.person;

import com.solvd.hospital.exceptions.InvalidBirthDateStatementException;
import com.solvd.hospital.exceptions.InvalidNameStatementException;
import com.solvd.hospital.exceptions.InvalidSexArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Scanner;

public abstract class Person {

    private final static Logger LOGGER = LoggerFactory.getLogger(Person.class);
    protected String fullName;
    protected String birthDate;
    protected Character sex;

    public String getFullName() {
        return fullName;
    }

    public final void setFullName(Scanner sc) throws InvalidNameStatementException {
        String fullName = sc.nextLine();
        if (fullName.split(" ").length == 3) {
            String editedFullName = fullName.replaceAll("\\s+", "");
            for (int i = 0; i < editedFullName.length(); i++) {
                if (!Character.isLetter(editedFullName.charAt(i))) {
                    throw new InvalidNameStatementException("В имени присутствуют символы,которые не являются буквами:" + fullName);
                }
            }
            this.fullName = fullName;
        } else {
            throw new InvalidNameStatementException("Неверный формат ФИО");
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public final void setBirthDate(Scanner sc) throws InvalidBirthDateStatementException {
        String birthDate = sc.nextLine();
        if (birthDate.split("\\.").length == 3) {
            String editedBirthDate = birthDate.replaceAll("\\.", "");
            for (int i = 0; i < editedBirthDate.length(); i++) {
                if (!Character.isDigit(editedBirthDate.charAt(i))) {
                    throw new InvalidBirthDateStatementException("В дате присутствуют символы,которые не являются числами: " + birthDate);
                }
                this.birthDate = birthDate;
            }
        } else {
            throw new InvalidBirthDateStatementException("Неверный формат даты");
        }
    }

    public Character getSex() {
        return sex;
    }

    public final void setSex(Scanner sc) throws InvalidSexArgumentException {
        Character sex = sc.nextLine().charAt(0);
        if (sex != 'м'
                && sex != 'ж') {
            throw  new InvalidSexArgumentException(sex + "- Не является символом(м/ж)");
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
