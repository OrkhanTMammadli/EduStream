package com.ltc.edustream.dto.response;

import java.time.Instant;

public record ExamResponse(
        Long id,
        Long courseId,
        String title,
        Instant startTime,
        Instant endTime,
        Integer durationMinutes,
        String status
) {}

