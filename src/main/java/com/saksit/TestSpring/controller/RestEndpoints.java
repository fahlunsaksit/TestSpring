package com.saksit.TestSpring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoints {

    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "saksit", required = false) String name,
                              @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount
    ) {
        return new Course(name, chapterCount);
    }


}
