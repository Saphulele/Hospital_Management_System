package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.timer.TimerAlarmClock;

public class HospitalManagementApplication {
    private static TimerAlarmClock SpringApplication;

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }
}