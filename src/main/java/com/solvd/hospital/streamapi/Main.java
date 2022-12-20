package com.solvd.hospital.streamapi;

import com.solvd.hospital.person.doctor.Dentist;
import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.doctor.Surgeon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    private static Logger LOOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Doctor doctor3 = new Surgeon("Vasya", "Surgeon", "9:00-13:00", new Random().ints(400, 500).findFirst().getAsInt());
        Doctor doctor4 = new Surgeon("Oleg", "Surgeon", "13:00-16:00", new Random().ints(400, 500).findFirst().getAsInt());
        Doctor doctor1 = new Dentist("Aleksej", "Dentist", "14:00-18:00", new Random().ints(100, 400).findFirst().getAsInt());
        Doctor doctor2 = new Dentist("Aleksej", "Dentist", "10:00-12:00", new Random().ints(100, 400).findFirst().getAsInt());

        ArrayList<Doctor> doctorArrayList = new ArrayList<>(List.of(doctor1, doctor2, doctor3, doctor4));

        doctorArrayList.stream().map(x -> x.getFullName().toUpperCase()).forEach(LOOGGER::info);

        LOOGGER.info(doctorArrayList.stream().filter(x -> x.getOfficeNumber() > 400).toList().toString());

        List<Doctor> doctorList = Stream.of(doctor4, doctor3, doctor1).sorted((o1, o2) -> o1.getID() - o2.getID()).collect(Collectors.toList());
        LOOGGER.info(doctorList.toString());

        LOOGGER.info(String.valueOf(Stream.builder().add(doctor2).add(doctor1).build().count()));

        LOOGGER.info(String.valueOf(Stream.of(0, 2, 1, 4, 1/*5*/).skip(1).distinct().count()));

        LOOGGER.info(String.valueOf(doctorArrayList.stream().filter(x -> x.getFullName().equals("Aleksej")).findFirst().get()));
    }
}
