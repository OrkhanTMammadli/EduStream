package com.ltc.edustream.service;

import com.ltc.edustream.dto.request.LessonCreateRequest;
import com.ltc.edustream.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {

    LessonResponse create(LessonCreateRequest request);
    List<LessonResponse> getByCourse(Long courseId);
    LessonResponse getById(Long id);
}
