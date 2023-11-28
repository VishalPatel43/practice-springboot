package com.udemy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define private field for the dependency
    private Coach coach;

    // define setter method for dependency injection
    @Autowired
    public void setCoach(Coach coach) { // also we can use any method name
        this.coach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
