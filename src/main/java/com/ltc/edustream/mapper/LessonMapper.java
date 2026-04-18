package com.ltc.edustream.mapper;

import com.ltc.edustream.dto.request.LessonCreateRequest;
import com.ltc.edustream.dto.response.LessonResponse;
import com.ltc.edustream.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LessonMapper {
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "id", ignore = true)
    Lesson toEntity(LessonCreateRequest request);
    @Mapping(source = "course.id", target = "courseId")
    LessonResponse toResponse(Lesson lesson);
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateLesson(LessonCreateRequest request, @MappingTarget Lesson lesson);
}
