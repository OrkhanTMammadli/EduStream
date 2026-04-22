package com.ltc.edustream.controller;


import com.ltc.edustream.entity.CourseUpdate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CourseWebSocketController {
    @MessageMapping("/course.update")
    @SendTo("/topic/course-updates")
    public CourseUpdate handleCourseUpdate (CourseUpdate update) {
        return update;
    }
}
