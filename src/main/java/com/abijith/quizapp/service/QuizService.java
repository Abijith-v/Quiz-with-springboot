package com.abijith.quizapp.service;

import com.abijith.quizapp.model.Questions;
import com.abijith.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Questions> getAllQuestions() {
        return quizRepository.findAll();
    }

    public List<Questions> getAllQuestionsByDifficulty(Integer difficultyLevel) {
        return quizRepository.findAllByDifficultyLevel(difficultyLevel);
    }
}
