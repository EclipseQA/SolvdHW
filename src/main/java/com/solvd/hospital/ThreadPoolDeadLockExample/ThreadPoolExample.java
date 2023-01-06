package com.solvd.hospital.ThreadPoolDeadLockExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadPoolExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExample.class);
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable task = () -> {
            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss:SS");
            LOGGER.info(currentTime.format(new Date()) + " - Поток: " + Thread.currentThread().getName() + " - Начал");
/*
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
*/
            LOGGER.info(currentTime.format(new Date()) + " - Поток: " + Thread.currentThread().getName() + " - Закончил");
        };

        for (int i = 0; i < 8; i++) {
            executor.execute(task);
        }

        executor.shutdown();
    }
}

