package com.abijith.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // lombok will make getters and setters
@Entity // To map model to table
public class Questions {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Auto increment
    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Integer answer;
    private Integer difficultyLevel;
}
