package com.jk.quizapp.service;
import com.jk.quizapp.dao.QuizDAO;
import com.jk.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class Quizservice {

    @Autowired
    QuizDAO quizdao;

    public ResponseEntity<List<Question>> getallquestions() {
        try {
            return new ResponseEntity<>(quizdao.findAll(), HttpStatus.OK);
            }catch (Exception e)
            {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    public ResponseEntity<List<Question>> getallquestionsBycategory(String category) {
        try {
            return new ResponseEntity<>(quizdao.findByCategory(category),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            quizdao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

    public ResponseEntity<String> deleteQuestion(Question id) {
        try {
            quizdao.delete(id);
            return new ResponseEntity<>("successfully deleted",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Question> updateQuestion(Integer id, Question questionDetails) {
        // Set the ID on the incoming object to specify which record to update
           questionDetails.setId(id);
        // Save the object and capture the final, persisted state from the database
           Question updatedQuestion = quizdao.save(questionDetails);
           // Return the updated object with a standard "OK" (200) status
        // ResponseEntity.ok() is a convenient shortcut for new ResponseEntity<>(..., HttpStatus.OK)
           return ResponseEntity.ok(updatedQuestion);
    }
}
