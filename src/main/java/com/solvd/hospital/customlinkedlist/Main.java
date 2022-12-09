package com.solvd.hospital.customlinkedlist;

import com.solvd.hospital.person.doctor.Dentist;
import com.solvd.hospital.person.doctor.Doctor;
import com.solvd.hospital.person.doctor.Endocrinologist;
import com.solvd.hospital.person.doctor.Surgeon;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Dentist("F", "F", "10 00", 111);
        Doctor doctor2 = new Surgeon("A", "A", "10 00", 111);
        Doctor doctor3 = new Endocrinologist("X", "X", "10 00", 111);
        TestList<Doctor> doctorTestList = new TestList<>();
        doctorTestList.add(doctor1);
        doctorTestList.add(doctor2);
        doctorTestList.add(doctor3);
        doctorTestList.set(0, doctor2);
        System.out.println(doctorTestList);

//        System.out.println(doctorTestList.get(1));
//        doctorTestList.add(2, doctor3);
//        System.out.println(doctorTestList.indexOf(doctor1));
//        doctorTestList.clear();
//        System.out.println(doctorTestList);
    }
}
