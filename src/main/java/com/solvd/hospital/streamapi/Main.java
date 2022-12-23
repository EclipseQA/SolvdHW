package com.solvd.hospital.streamapi;

import com.solvd.hospital.person.doctor.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    private static Logger LOOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Doctor doctor3 = new Surgeon("Vasya", Specialty.Surgeon, "9:00-13:00", new Random().ints(401, 500).findFirst().getAsInt());
        Doctor doctor4 = new Neurologist("Oleg", Specialty.Nephrologist, "13:00-16:00", new Random().ints(401, 500).findFirst().getAsInt());
        Doctor doctor1 = new Dentist("Aleksej", Specialty.Dentist, "14:00-18:00", new Random().ints(100, 400).findFirst().getAsInt());
        Doctor doctor2 = new Dentist("Aleksej", Specialty.Dentist, "10:00-12:00", new Random().ints(100, 400).findFirst().getAsInt());
        Doctor doctor5 = new Endocrinologist("Igor", Specialty.Endocrinologist, "10:00-12:00", new Random().ints(100, 400).findFirst().getAsInt());

        ArrayList<Doctor> doctorArrayList = new ArrayList<>(List.of(doctor5, doctor2, doctor1, doctor3, doctor4));

        LOOGGER.info(Arrays.toString(doctorArrayList.stream().filter(x -> x.getOfficeNumber() < 400 && x.getSpecialty().equals(Specialty.Endocrinologist)) //doc1,2,5
                .collect(Collectors.toSet())
                .stream().collect(Collectors.toList())
                .stream().toArray()));

        Stream.of(doctor4, doctor3, doctor1).sorted((o1, o2) -> o1.getID() - o2.getID()).forEach(x -> LOOGGER.info(x.toString()));


        LOOGGER.info(Stream.builder().add(doctor4).add(doctor1).add(doctor5). /*3*/ build().skip(1).count() + "\n");

        if (doctorArrayList.stream().anyMatch(x -> x.getFullName().equals("1"))) {
            LOOGGER.info(String.valueOf(doctorArrayList.stream().mapToInt(Doctor::getID).reduce((x, y) -> x + y).orElse(Integer.MAX_VALUE)));
        } else {
            doctorArrayList.stream().map(Doctor::getFullName).peek(x -> LOOGGER.info("Before skipping: " + x))
                    .distinct().limit(3).forEachOrdered(x ->
                            LOOGGER.info("After skipping: " + x));
        }
    }
}
