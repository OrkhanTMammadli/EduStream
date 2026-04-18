package com.ltc.edustream.service;

import com.ltc.edustream.dto.request.CourseCreateRequest;
import com.ltc.edustream.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse create(CourseCreateRequest request);
    CourseResponse updateCourse (Long id, CourseCreateRequest request);
    CourseResponse getById(Long id);
    void deleteCourse (Long id);
    List<CourseResponse> getAll();
    List<CourseResponse> getByTeacher(String teacherName);
}
