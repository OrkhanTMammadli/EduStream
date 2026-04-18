package com.ltc.edustream.dto.request;

public record AnswerSubmitRequest(
        Long examSessionId,
        Long questionId,
        String answerText
) {}
