package com.jk.quizapp.dao;

import com.jk.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

}
