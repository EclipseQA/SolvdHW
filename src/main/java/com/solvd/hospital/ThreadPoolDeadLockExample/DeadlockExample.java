package com.solvd.hospital.ThreadPoolDeadLockExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.solvd.hospital.ThreadPoolDeadLockExample.DeadlockExample.lock1;
import static com.solvd.hospital.ThreadPoolDeadLockExample.DeadlockExample.lock2;


public class DeadlockExample {
    static Lock lock1 = new ReentrantLock(true);
    static Lock lock2 = new ReentrantLock(true);
    static Doctor doctor = new Doctor();
    static Patient patient = new Patient();

    public static void main(String[] args) {

        new Thread(() -> doctor.treatPatient(patient), "Доктор").start();
        new Thread(() -> patient.visitDoctor(doctor), "Пациент").start();
    }

}

class Doctor {
    Logger LOGGER = LoggerFactory.getLogger(Doctor.class);
    String name = "Доктор Игорь";

    public void treatPatient(Patient patient) {
        lock1.lock();
        LOGGER.info(name + " ждет " + patient.name);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        LOGGER.info(name + "лечит " + patient.name);
    }
}

class Patient {
    Logger LOGGER = LoggerFactory.getLogger(Patient.class);
    String name = "Пациент Степан";

    public void visitDoctor(Doctor doctor) {
        lock2.lock();
        LOGGER.info(name + " приходит к " + doctor.name);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        LOGGER.info(name + " объясняет проблему " + doctor.name);
    }
}


/*    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Patient patient = new Patient();

        Thread thread1 = new Thread(() -> doctor.treatPatient(patient));
        Thread thread2 = new Thread(() -> patient.getTreatment(doctor));
        thread1.start();
        thread2.start();
    }
}

class Doctor {
    Logger LOGGER = LoggerFactory.getLogger(Doctor.class);
    public void treatPatient(Patient patient) {
        synchronized (this) {
            LOGGER.info("Doctor: treating patient");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (patient) {
                LOGGER.info("Doctor: finished treatment");
            }
        }
    }
}

class Patient {
    Logger LOGGER = LoggerFactory.getLogger(Patient.class);

    public void getTreatment(Doctor doctor) {
        synchronized (this) {
            LOGGER.info("Patient: getting treatment");
            synchronized (doctor) {
                LOGGER.info("Patient: received treatment");
            }
        }*/
