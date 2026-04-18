package com.ltc.edustream.dto.response;

import java.time.Instant;

public record ExamSessionResponse(
        Long id,
        Long examId,
        String studentName,
        String status,
        Instant startedAt,
        Instant finishedAt,
        Double totalScore
) {}

