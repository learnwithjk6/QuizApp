package com.jk.quizapp.controller;
import com.jk.quizapp.model.Question;
import com.jk.quizapp.service.Quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("question")
public class QuizController {

    @Autowired
    Quizservice quizservice;

    @GetMapping("/getallquestions")
    public ResponseEntity<List<Question>> getallquestion(){
        return quizservice.getallquestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getallquestionsBycategory(@PathVariable String category){
        return quizservice.getallquestionsBycategory(category);
    }

    @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return quizservice.addQuestion(question);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") Question id){
        return quizservice.deleteQuestion(id);
    }
    // Keep this controller exactly as it was
    @PutMapping("update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question questionDetails) {
        return quizservice.updateQuestion(id, questionDetails);
    }


}
