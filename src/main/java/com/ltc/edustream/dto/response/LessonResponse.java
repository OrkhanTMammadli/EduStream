package com.ltc.edustream.dto.response;

import java.time.Instant;
import java.util.Set;

public record LessonResponse(
        Long id,
        Long courseId,
        String title,
        String content,
        Set<String> attachments,
        Instant createdAt
) {}

