package com.ltc.edustream.mapper;

import com.ltc.edustream.dto.request.ExamSessionStartRequest;
import com.ltc.edustream.dto.response.ExamSessionResponse;
import com.ltc.edustream.entity.Exam;
import com.ltc.edustream.entity.ExamSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ExamSessionMapper {
    ExamSession toEntity (ExamSessionStartRequest request);
    ExamSessionResponse toResponse (ExamSession examSession);
}
