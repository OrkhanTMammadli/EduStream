package com.ltc.edustream.controller;

import com.ltc.edustream.dto.request.LessonCreateRequest;
import com.ltc.edustream.dto.response.LessonResponse;
import com.ltc.edustream.service.implement.LessonServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonServiceImpl lessonServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<LessonResponse> create(@Valid @RequestBody LessonCreateRequest request) {
        LessonResponse lessonResponse = lessonServiceImpl.create(request);
        return new ResponseEntity<>(lessonResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getById (@PathVariable Long id) {
        LessonResponse lessonResponse = lessonServiceImpl.getById(id);
        return new ResponseEntity<>(lessonResponse, HttpStatus.OK);
    }
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<LessonResponse>> getByCourse (@PathVariable Long courseId){
        List<LessonResponse> lessonResponse = lessonServiceImpl.getByCourse(courseId);
        return new ResponseEntity<>(lessonResponse,HttpStatus.ACCEPTED);
    }
}

