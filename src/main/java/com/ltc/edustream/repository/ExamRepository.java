package com.ltc.edustream.repository;

import com.ltc.edustream.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByCourseId(Long courseId);

    @Query("""
        SELECT e FROM Exam e
        JOIN e.course c
        WHERE c.teacherName = :teacherName
    """)
    List<Exam> findExamsByTeacher(String teacherName);
}