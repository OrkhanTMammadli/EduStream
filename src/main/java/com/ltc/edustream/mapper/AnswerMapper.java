package com.ltc.edustream.mapper;

import com.ltc.edustream.dto.request.AnswerSubmitRequest;
import com.ltc.edustream.dto.response.AnswerResponse;
import com.ltc.edustream.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AnswerMapper {
    Answer toEntity (AnswerSubmitRequest request);
    AnswerResponse toResponse (Answer answer);
}
