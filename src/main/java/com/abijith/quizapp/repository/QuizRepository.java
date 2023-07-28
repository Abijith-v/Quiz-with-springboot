package com.abijith.quizapp.repository;

import com.abijith.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Questions, Integer> {

    List<Questions> findAllByDifficultyLevel(Integer difficultyLevel);
}
