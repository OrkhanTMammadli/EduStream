package com.ltc.edustream.service.implement;

import com.ltc.edustream.dto.request.LessonCreateRequest;
import com.ltc.edustream.dto.response.LessonResponse;
import com.ltc.edustream.entity.Course;
import com.ltc.edustream.entity.Lesson;
import com.ltc.edustream.exception.LessonNotFoundException;
import com.ltc.edustream.mapper.LessonMapper;
import com.ltc.edustream.repository.CourseRepository;
import com.ltc.edustream.repository.LessonRepository;
import com.ltc.edustream.service.ServiceMethods.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonResponse create(LessonCreateRequest request) {
        Course course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Lesson lesson = lessonMapper.toEntity(request);
        lesson.setCourse(course);
        Lesson saved = lessonRepository.save(lesson);
        return lessonMapper.toResponse(saved);
    }


    @Override
    public List<LessonResponse> getByCourse(Long courseId) {
        return lessonRepository.findByCourseId(courseId)
                .stream()
                .map(lessonMapper::toResponse)
                .toList();
    }

    @Override
    public LessonResponse getById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found"));
        return lessonMapper.toResponse(lesson);
    }
}
