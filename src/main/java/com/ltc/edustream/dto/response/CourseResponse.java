package com.ltc.edustream.dto.response;

import java.time.Instant;

public record CourseResponse(
        Long id,
        String title,
        String description,
        String teacherName,
        Instant createdAt
) {}

