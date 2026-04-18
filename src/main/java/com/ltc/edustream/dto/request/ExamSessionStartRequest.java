package com.ltc.edustream.dto.request;

public record ExamSessionStartRequest(
        Long examId,
        String studentName
) {}
