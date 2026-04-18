package com.ltc.edustream.service.implement;

import com.ltc.edustream.dto.request.CourseCreateRequest;
import com.ltc.edustream.dto.response.CourseResponse;
import com.ltc.edustream.entity.Course;
import com.ltc.edustream.exception.CourseNotFoundException;
import com.ltc.edustream.mapper.CourseMapper;
import com.ltc.edustream.repository.CourseRepository;
import com.ltc.edustream.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {
        Course course = courseMapper.toEntity(request);
        courseRepository.save(course);
        return courseMapper.toResponse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseCreateRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new CourseNotFoundException("Course not found"));
        courseMapper.updateCourse(request,course);
        courseRepository.save(course);
        return courseMapper.toResponse(course);
    }

    @Override
    public CourseResponse getById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toResponse(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseResponse> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public List<CourseResponse> getByTeacher(String teacherName) {
        return courseRepository.findByTeacherName(teacherName)
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }
}

