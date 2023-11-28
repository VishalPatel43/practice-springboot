package com.udemy.demo;

import org.springframework.stereotype.Component;

@Component // make available for dependency injection
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
