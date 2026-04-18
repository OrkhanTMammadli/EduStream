package com.ltc.edustream.dto.response;

public record AnswerResponse(
        Long id,
        Long examSessionId,
        Long questionId,
        String answerText,
        Boolean isCorrect,
        Double scoreAwarded
) {}

