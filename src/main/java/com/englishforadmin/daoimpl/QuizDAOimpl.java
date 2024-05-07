package com.englishforadmin.daoimpl;

import com.englishforadmin.dao.QuizDAO;
import com.englishforadmin.myconnection.MySQLconnection;
import model.Quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAOimpl implements QuizDAO {
    private Connection connection;
    public QuizDAOimpl (Connection connection)
    {
        this.connection = connection;
    }
    @Override
    public List<Quiz> getAllQuizzes() throws SQLException {
        try {
            List<Quiz> quizzes = new ArrayList<>();

            String query = "SELECT q.IdQuiz, q.Title, q.Status FROM quiz q";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Quiz quiz = new Quiz();
                    quiz.setIdQuiz(resultSet.getString("IdQuiz"));
                    quiz.setTitle(resultSet.getString("Title"));
                    quiz.setStatus(Quiz.QuizStatus.valueOf(resultSet.getString("Status").toLowerCase()));

                    quizzes.add(quiz);
                }
            }
            return quizzes;
        } catch (SQLException ex) {
            // In ra lỗi và throw lại exception
            ex.printStackTrace();
            throw ex;
        }
    }
    @Override
    public Quiz getQuizById(String quizId) {
        Connection connection = MySQLconnection.getConnection();
        Quiz quiz = null;

        try {
            String sql = "SELECT * FROM quiz WHERE IdQuiz = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, quizId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                quiz = new Quiz();
                quiz.setIdQuiz(resultSet.getString("IdQuiz"));
                quiz.setTitle(resultSet.getString("Title"));
                quiz.setStatus(Quiz.QuizStatus.valueOf(resultSet.getString("Status").toLowerCase()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quiz;
    }


}
