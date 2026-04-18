package com.ltc.edustream.mapper;

import com.ltc.edustream.dto.request.CourseCreateRequest;
import com.ltc.edustream.dto.response.CourseResponse;
import com.ltc.edustream.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseCreateRequest request);
    CourseResponse toResponse(Course course);
    void updateCourse (CourseCreateRequest request, @MappingTarget Course course);
}

