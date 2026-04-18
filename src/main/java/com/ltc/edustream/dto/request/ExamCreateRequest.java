package com.ltc.edustream.dto.request;

import java.time.Instant;

public record ExamCreateRequest(
        Long courseId,
        String title,
        Instant startTime,
        Instant endTime,
        Integer durationMinutes
) {}

