package com.saksit.TestSpring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestEndpoints {
    /* mvn spring-boot:run -Dspring.profiles.active=qa
     *
     * command for run profile application-qa.properties
     * */

    /*data comming from application.properties*/
    @Value("${default.course.name}")
    private String cName;

    @Value("${default.corse.chapterCount}")
    private int chaptersCount;
    /*data comming from application.properties*/

    @RequestMapping("/defaultCourse")
    public Course getDefaultCourse(@RequestParam(value = "name", defaultValue = "saksit", required = false) String name,
                                   @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount
    ) {
        return new Course(cName, chaptersCount);
    }

    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "saksit", required = false) String name,
                              @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount
    ) {
        return new Course(name, chapterCount);
    }

    @RequestMapping("/")
    public String getEndpoint() {
        return "WELCOME MY WEB SPRING";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course) {
        return "Your code named " + course.getName() + " with " + course.getChapterCount() + " chapters saved successfuly";
    }


}
