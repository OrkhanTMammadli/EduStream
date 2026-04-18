package com.ltc.edustream.mapper;

import com.ltc.edustream.dto.request.QuestionCreateRequest;
import com.ltc.edustream.dto.response.QuestionResponse;
import com.ltc.edustream.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface QuestionMapper {
    Question toEntity (QuestionCreateRequest request);
    QuestionResponse toResponse (Question question);
}
