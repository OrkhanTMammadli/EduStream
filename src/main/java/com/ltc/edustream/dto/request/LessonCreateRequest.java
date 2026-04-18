package com.ltc.edustream.dto.request;

import java.util.Set;

public record LessonCreateRequest(
        Long courseId,
        String title,
        String content,
        Set<String> attachments
) {}
