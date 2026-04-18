package com.ltc.edustream.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @MapKeyColumn(name = "option_key")
    @Column(name = "option_text")
    private Map<String, String> options;
    @Column(name = "correct_answer", columnDefinition = "text")
    private String correctAnswer;
    private Double score = 1.0;
}
