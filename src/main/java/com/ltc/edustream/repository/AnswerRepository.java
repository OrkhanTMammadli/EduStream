package com.ltc.edustream.repository;

import com.ltc.edustream.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByExamSessionId(Long examSessionId);

    @Query("""
        SELECT a FROM Answer a
        JOIN FETCH a.question q
        WHERE a.examSession.id = :sessionId
    """)
    List<Answer> findFullAnswersBySession(Long sessionId);
}
