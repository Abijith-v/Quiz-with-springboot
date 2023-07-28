package com.abijith.quizapp.controller;

import com.abijith.quizapp.model.Questions;
import com.abijith.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/getall")
    public List<Questions> getAll() {
        return quizService.getAllQuestions();
    }

    @GetMapping("/difficulty/{difficultyLevel}")
    public List<Questions> getAllByCategory(@PathVariable Integer difficultyLevel) {
        return quizService.getAllQuestionsByDifficulty(difficultyLezvel);
    }
}
