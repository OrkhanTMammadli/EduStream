package com.ltc.edustream.dto.request;

import com.ltc.edustream.entity.QuestionType;

import java.util.Map;

public record QuestionCreateRequest(
        Long examId,
        String text,
        QuestionType type,
        Map<String, String> options,
        String correctAnswer,
        Double score
) {}
