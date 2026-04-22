package com.ltc.edustream.service;

import com.ltc.edustream.entity.CourseUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursePushService {
    private final SimpMessagingTemplate template;
    public void pushCourseUpdate(long courseId, String title, int lessonCount) {
        CourseUpdate update = new CourseUpdate(courseId, title, lessonCount);
        template.convertAndSend("/topic/course-updates", update);
    }
}