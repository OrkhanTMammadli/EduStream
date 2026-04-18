package com.ltc.edustream.repository;

import com.ltc.edustream.entity.ExamSession;
import com.ltc.edustream.entity.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamSessionRepository extends JpaRepository<ExamSession, Long> {
    List<ExamSession> findByExamId(Long examId);
    List<ExamSession> findByStudentName(String studentName);
    List<ExamSession> findByStatus(SessionStatus status);
}


