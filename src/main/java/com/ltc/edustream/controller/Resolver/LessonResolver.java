package com.ltc.edustream.controller.Resolver;

import com.ltc.edustream.dto.request.LessonCreateRequest;
import com.ltc.edustream.dto.response.LessonResponse;
import com.ltc.edustream.service.ServiceMethods.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class LessonResolver {

    private final LessonService lessonService;

    @QueryMapping
    public LessonResponse lesson(@Argument Long id) {
        return lessonService.getById(id);
    }

    @QueryMapping
    public List<LessonResponse> lessonsByCourse(@Argument Long courseId) {
        return lessonService.getByCourse(courseId);
    }

    @MutationMapping
    public LessonResponse createLesson(@Argument LessonCreateRequest request) {
        return lessonService.create(request);
    }
}
