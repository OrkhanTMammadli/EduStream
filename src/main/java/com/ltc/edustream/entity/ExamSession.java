package com.ltc.edustream.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "exam_sessions")
public class ExamSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
    private String studentName;
    @Enumerated(EnumType.STRING)
    private SessionStatus status; //
    private Instant startedAt;
    private Instant finishedAt;
    private Double totalScore;
}

