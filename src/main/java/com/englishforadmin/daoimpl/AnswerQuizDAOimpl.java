package com.englishforadmin.daoimpl;

import com.englishforadmin.dao.AnswerQuizDAO;
import model.AnswerQuiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerQuizDAOimpl implements AnswerQuizDAO {
    private Connection connection;
    public AnswerQuizDAOimpl(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public List<AnswerQuiz> getAllAnswerByQuestionQuizID(String questionQuizID) throws SQLException {
        List<AnswerQuiz> answers = new ArrayList<>();
        String sql = "SELECT * FROM answerquiz WHERE IdQuestionQuiz = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, questionQuizID);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String idAnswerQuiz = resultSet.getString("IdAnswerQuiz");
                    String content = resultSet.getString("Content");
                    boolean isCorrect = resultSet.getBoolean("IsCorrect");

                    // Tạo một câu trả lời mới và thêm vào danh sách
                    AnswerQuiz answer = new AnswerQuiz(idAnswerQuiz, content, isCorrect, questionQuizID);
                    answers.add(answer);
                }
            }
        }

        return answers;
    }

}
