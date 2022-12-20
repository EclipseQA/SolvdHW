package com.solvd.hospital.lambdas;

import com.solvd.hospital.person.doctor.Dentist;
import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.doctor.Endocrinologist;
import com.solvd.hospital.person.doctor.Surgeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Dentist("Aleksej", "Super", "10 00", 111);
        Doctor doctor2 = new Surgeon("A", "A", "10 00", 111);
        Doctor doctor3 = new Endocrinologist("X", "X", "10 00", 111);
        ArrayList<Doctor> doctorArrayList = new ArrayList<>(List.of(doctor1, doctor2, doctor3));

        IConsoleFields<Object> getFields = x -> System.out.println(Arrays.toString
                (x.getClass().getDeclaredFields()));

        getFields.run(doctor1);


        IComparable<Doctor, Doctor> comparable = (x, y) ->
                x.hashCode() == y.hashCode() && x.getFullName().equals(y.getFullName());
        System.out.println(comparable.compare(doctor1, doctor2));

        IConcat<String, String, String> iConcat =
                (firstValue, separator, secondValue) -> firstValue + separator + secondValue;
        System.out.println(iConcat.concat(doctor1.getFullName(), " ", doctor1.getSpecialty()));
    }
}


@FunctionalInterface
interface IConsoleFields<T> {
    void run(T t);
}

@FunctionalInterface
interface IComparable<T, F> {
    boolean compare(T t, F f);
}

@FunctionalInterface
interface IConcat<T, C, S> {
    String concat(T t, C c, S s);
}