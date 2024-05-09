package com.englishforadmin.dao;

import model.Quiz;

import java.sql.SQLException;
import java.util.List;

public interface QuizDAO {
    List<Quiz> getAllQuizzes() throws SQLException;

    Quiz getQuizById(String quizId);

    //void addQuiz(Quiz quiz);

    boolean updateQuiz(Quiz quiz);

    //void deleteQuiz(int quizId);
}