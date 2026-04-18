package com.ltc.edustream.dto.response;

import com.ltc.edustream.entity.QuestionType;

import java.util.Map;

public record QuestionResponse(
        Long id,
        Long examId,
        String text,
        QuestionType type,
        Map<String, String> options,
        String correctAnswer,
        Double score
) {}

