package com.englishforadmin.daoimpl;

import com.englishforadmin.dao.QuestionQuizDAO;
import com.englishforadmin.myconnection.MySQLconnection;
import model.AnswerQuiz;
import model.QuestionQuiz;
import model.Quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionQuizDAOimpl implements QuestionQuizDAO {
    private Connection connection;

    // Constructor
    public QuestionQuizDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<QuestionQuiz> getAllQuestionByQuizID(String quizID) throws SQLException {

        AnswerQuizDAOimpl answerQuizDAOimpl = new AnswerQuizDAOimpl(connection);
        List<QuestionQuiz> questionQuizzes = new ArrayList<>();
        String sql = "SELECT * FROM questionquiz WHERE IdQuiz = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, quizID);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {

                    String idQuestionQuiz = resultSet.getString("IdQuestionQuiz");
                    String content = resultSet.getString("Content");
                    int serial = resultSet.getInt("Serial");
                    byte[] image = resultSet.getBytes("Image");
                    if ( idQuestionQuiz != null) {
                        List<AnswerQuiz> answerQuizList = answerQuizDAOimpl.getAllAnswerByQuestionQuizID(idQuestionQuiz);
                        QuestionQuiz questionQuiz = new QuestionQuiz(idQuestionQuiz, content, serial, image, quizID, answerQuizList);
                        questionQuizzes.add(questionQuiz);
                    }
                }
            }
        }


        return questionQuizzes;

    }
    @Override
    public boolean updateQuestionQuiz(QuestionQuiz questionQuiz) throws SQLException {
        String sql = "UPDATE questionquiz SET Content = ?, Serial = ?, Image = ? WHERE IdQuestionQuiz = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, questionQuiz.getContent());
            statement.setInt(2, questionQuiz.getSerial());
            statement.setBytes(3, questionQuiz.getImage());
            statement.setString(4, questionQuiz.getIdQuestionQuiz());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

}
