package com.ltc.edustream.entity;


import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private Instant startTime;
    private Instant endTime;
    private Integer durationMinutes;
    @Enumerated(EnumType.STRING)
    private ExamStatus status;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questions;
    private Instant createdAt = Instant.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;



}
