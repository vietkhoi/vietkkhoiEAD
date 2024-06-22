package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "student_score_t")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private Subject subject;

    @Column(name = "score1", nullable = false)
    private double score1;

    @Column(name = "score2", nullable = false)
    private double score2;

    public StudentScore(int studentId, int subjectId, double score1, double score2) {
    }



    // Getters and Setters
}