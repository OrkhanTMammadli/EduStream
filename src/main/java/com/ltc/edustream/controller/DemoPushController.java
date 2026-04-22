package com.ltc.edustream.controller;


import com.ltc.edustream.service.CoursePushService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoPushController {

    private final CoursePushService pushService;

    public DemoPushController(CoursePushService pushService) {
        this.pushService = pushService;
    }

    @PostMapping("/push")
    public void push(@RequestParam long id, @RequestParam String title, @RequestParam int lessons) {
        pushService.pushCourseUpdate(id, title, lessons);
    }
}
