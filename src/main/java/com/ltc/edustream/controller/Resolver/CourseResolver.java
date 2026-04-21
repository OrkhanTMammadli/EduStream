package com.ltc.edustream.controller.Resolver;


import com.ltc.edustream.dto.request.CourseCreateRequest;
import com.ltc.edustream.dto.response.CourseResponse;
import com.ltc.edustream.service.ServiceMethods.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseResolver {

    private final CourseService courseService;

    @QueryMapping
    public CourseResponse course(@Argument Long id) {
        return courseService.getById(id);
    }

    @QueryMapping
    public List<CourseResponse> courses() {
        return courseService.getAll();
    }

    @QueryMapping
    public List<CourseResponse> coursesByTeacher(@Argument String teacherName) {
        return courseService.getByTeacher(teacherName);
    }

    @MutationMapping
    public CourseResponse createCourse(@Argument CourseCreateRequest request) {
        return courseService.create(request);
    }
}

