package com.saksit.TestSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RestEndpoints {
    /* mvn spring-boot:run -Dspring.profiles.active=qa
     *
     * command for run profile application-qa.properties
     * */

    /*data comming from application.properties*/
    @Value("${course.name}")
    private String cName;

    @Value("${course.chapterCount}")
    private int chaptersCount;
    /*data comming from application.properties*/

    @Autowired
    private CourseConfiguration courseConfiguration;

    @RequestMapping("/defaultCourse")
    public Course getDefaultCourse(@RequestParam(value = "name", defaultValue = "saksit", required = false) String name,
                                   @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount
    ) {
        return new Course(cName, chaptersCount);
    }


    @RequestMapping("/getHierarchical")
    public HashMap<String,Object> getConfigAnnotateProperties() {
        HashMap<String,Object> map = new HashMap<String,Object>();

        map.put("name", courseConfiguration.getName());
        map.put("chapterCount", courseConfiguration.getChapterCount());
        map.put("rating", courseConfiguration.getRating());
        map.put("author", courseConfiguration.getAuthor());


        return map;
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
