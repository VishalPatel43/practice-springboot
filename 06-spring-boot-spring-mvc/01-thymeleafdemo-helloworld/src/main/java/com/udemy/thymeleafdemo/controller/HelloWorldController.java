package com.udemy.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model

    @RequestMapping("processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model theModel) { // processFormVersionTwo

        // read a request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add the message to the model
        theModel.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model theModel) {

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey my friend from v3! " + theName;

        // add the message to the model
        theModel.addAttribute("message", result);

        return "helloworld";
    }
}
