package com.englishforadmin.dao;

import model.AnswerQuiz;

import java.sql.SQLException;
import java.util.List;

public interface AnswerQuizDAO {
    List<AnswerQuiz> getAllAnswerByQuestionQuizID ( String questionQuizID) throws SQLException;

}
