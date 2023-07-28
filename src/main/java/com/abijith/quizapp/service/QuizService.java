package com.abijith.quizapp.service;

import com.abijith.quizapp.helper.ResponseTemplate;
import com.abijith.quizapp.model.Questions;
import com.abijith.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService {

    public static int STATUS_CODE_200 = 200;
    public static int STATUS_CODE_201 = 201;
    public static int STATUS_CODE_500 = 500;

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<ResponseTemplate<List<Questions>>> getAllQuestions() {

        ResponseTemplate<List<Questions>> responseList = new ResponseTemplate<>();
        try {
            responseList.setResponse(quizRepository.findAll());
            responseList.setMessage("Successfully fetched all questions");
            responseList.setStatusCode(STATUS_CODE_200);
            System.out.println(responseList);
            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseList.setStatusCode(STATUS_CODE_500);
            responseList.setMessage("Failed to fetch " + e.getMessage());
        }

        return new ResponseEntity<>(responseList, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<ResponseTemplate<List<Questions>>> getAllQuestionsByDifficulty(Integer difficultyLevel) {

        ResponseTemplate<List<Questions>> responseList = new ResponseTemplate<>();
        try {
            responseList.setResponse(quizRepository.findAllByDifficultyLevel(difficultyLevel));
            responseList.setStatusCode(STATUS_CODE_200);
            responseList.setMessage("Successfully fetched questions by difficulty");
            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseList.setStatusCode(STATUS_CODE_200);
            responseList.setMessage("Failed to fetch by difficulty " + e.getMessage());
        }

        return new ResponseEntity<>(responseList, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<ResponseTemplate<String>> addNewQuestion(Questions question) {

        ResponseTemplate<String> responseTemplate = new ResponseTemplate<>();
        try {
            quizRepository.save(question);
            responseTemplate.setStatusCode(STATUS_CODE_201);
            responseTemplate.setMessage("Successfully added new question");
            return new ResponseEntity<>(responseTemplate, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseTemplate.setMessage("Failed to add new question " + e.getMessage());
            responseTemplate.setStatusCode(STATUS_CODE_500);
        }

        return new ResponseEntity<>(responseTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<ResponseTemplate<String>> deleteQuestionWithId(Integer id) {

        ResponseTemplate<String> responseTemplate = new ResponseTemplate<>();
        try {
            quizRepository.deleteById(id);
            responseTemplate.setStatusCode(STATUS_CODE_200);
            responseTemplate.setMessage("Successfully deleted the question");
            return new ResponseEntity<>(responseTemplate, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseTemplate.setStatusCode(STATUS_CODE_500);
            responseTemplate.setMessage("Failed to delete the question " + e.getMessage());
        }

        return new ResponseEntity<>(responseTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
