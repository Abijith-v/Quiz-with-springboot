package com.abijith.quizapp.controller;

import com.abijith.quizapp.helper.ResponseTemplate;
import com.abijith.quizapp.model.Questions;
import com.abijith.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/getall")
    public ResponseEntity<ResponseTemplate<List<Questions>>> getAll() {
        return quizService.getAllQuestions();
    }

    @GetMapping("/difficulty/{difficultyLevel}")
    public ResponseEntity<ResponseTemplate<List<Questions>>> getAllByCategory(@PathVariable Integer difficultyLevel) {
        return quizService.getAllQuestionsByDifficulty(difficultyLevel);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseTemplate<String>> addNewQuestions(@RequestBody Questions question) {
        return quizService.addNewQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseTemplate<String>> deleteAnExistingQuestion(@PathVariable Integer id) {
        return quizService.deleteQuestionWithId(id);
    }
}
