package com.ltc.edustream.repository;

import com.ltc.edustream.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByTeacherName(String teacherName);
    Optional<Course> findByTitleContainingIgnoreCase(String title);
    }
