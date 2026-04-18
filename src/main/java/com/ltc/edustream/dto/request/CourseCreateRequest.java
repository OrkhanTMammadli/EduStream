package com.ltc.edustream.dto.request;

import lombok.Data;

public record CourseCreateRequest(
        String title,
        String description,
        String teacherName
) {}
