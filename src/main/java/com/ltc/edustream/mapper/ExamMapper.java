package com.ltc.edustream.mapper;

import com.ltc.edustream.dto.request.ExamCreateRequest;
import com.ltc.edustream.dto.response.ExamResponse;
import com.ltc.edustream.entity.Exam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ExamMapper {
    Exam toEntity (ExamCreateRequest request);
    ExamResponse toResponse (Exam exam);
}
