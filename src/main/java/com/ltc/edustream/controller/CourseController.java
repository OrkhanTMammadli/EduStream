package com.ltc.edustream.controller;

import com.ltc.edustream.dto.request.CourseCreateRequest;
import com.ltc.edustream.dto.response.CourseResponse;
import com.ltc.edustream.service.implement.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Slf4j

public class CourseController {

    private final CourseServiceImpl courseServiceImpl;

    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponse> create(@Valid @RequestBody CourseCreateRequest request) {
        CourseResponse courseResponse = courseServiceImpl.create(request);
        log.info("Course added");
        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getById(@PathVariable Long id) {
        CourseResponse courseResponse = courseServiceImpl.getById(id);
        return new ResponseEntity<>(courseResponse,HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseResponse>> getAll() {
        List<CourseResponse> allCourses = courseServiceImpl.getAll();
        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherName}")
    public ResponseEntity<List<CourseResponse>> getByTeacher(@PathVariable String teacherName) {
        List<CourseResponse> foundTeacher = courseServiceImpl.getByTeacher(teacherName);
        return new ResponseEntity<>(foundTeacher,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponse> update(@PathVariable Long id, @RequestBody CourseCreateRequest request) {
        CourseResponse updated = courseServiceImpl.updateCourse(id, request);
        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        courseServiceImpl.deleteCourse(id);
        return new ResponseEntity<>("Course deleted",HttpStatus.ACCEPTED);
    }
}

