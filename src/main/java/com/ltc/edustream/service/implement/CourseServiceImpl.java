package com.ltc.edustream.service.implement;

import com.ltc.edustream.dto.request.CourseCreateRequest;
import com.ltc.edustream.dto.response.CourseResponse;
import com.ltc.edustream.entity.Course;
import com.ltc.edustream.exception.CourseNotFoundException;
import com.ltc.edustream.mapper.CourseMapper;
import com.ltc.edustream.repository.CourseRepository;
import com.ltc.edustream.service.ServiceMethods.CourseService;
import com.ltc.edustream.service.EmailService.EmailService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final static String COURSE_CACHE_NAME = "courseCache";
    private final EmailService emailService;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper, EmailService emailService) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.emailService = emailService;
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {
        Course course = courseMapper.toEntity(request);
        courseRepository.save(course);
        emailService.sendHtmlEmail(
                "ordukhanm20@outlook.com",
                "Education Stream System",
                "New Course has been created");
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
    @Cacheable(value = COURSE_CACHE_NAME)
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

