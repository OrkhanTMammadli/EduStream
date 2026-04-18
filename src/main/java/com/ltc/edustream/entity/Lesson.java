package com.ltc.edustream.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    private String title;
    private String content;

    @ElementCollection
    @CollectionTable(name = "lesson_attachments", joinColumns = @JoinColumn(name = "lesson_id"))
    @Column(name = "attachment_url")
    private Set<String> attachments;

    @CreationTimestamp
    private Instant createdAt = Instant.now();
}
