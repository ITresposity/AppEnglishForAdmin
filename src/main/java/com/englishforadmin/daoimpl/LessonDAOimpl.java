package com.englishforadmin.daoimpl;

import com.englishforadmin.dao.LessonDAO;
import com.englishforadmin.myconnection.MySQLconnection;
import model.Lesson;
import model.Quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDAOimpl implements LessonDAO {
    private Connection connection ;

    public LessonDAOimpl(Connection connection) {
        this.connection = connection;
     }


    @Override
    public List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();

        String query = "SELECT l.IdLesson ,l.Serial , l.Name, l.Status FROM Lesson l";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Lesson lesson = new Lesson();

                lesson.setIdLesson(resultSet.getString("IdLesson"));
                lesson.setSerial(resultSet.getInt("Serial"));
                lesson.setName(resultSet.getString("Name"));
                lesson.setStatus(Lesson.LessonStatus.valueOf(resultSet.getString("Status").toLowerCase()));

                lessons.add(lesson);
            }
        }

        return lessons;
    }

    @Override
    public Lesson getLessonById(String lessonId) {
        // Kết nối với cơ sở dữ liệu
        Connection connection = MySQLconnection.getConnection();
        Lesson lesson = null;

        try {
            // Tạo truy vấn SQL để lấy bài học với idLesson tương ứng
            String sql = "SELECT * FROM lesson WHERE IdLesson = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lessonId);

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Nếu có kết quả từ truy vấn
            if (resultSet.next()) {
                // Tạo một đối tượng Lesson mới và gán giá trị từ kết quả của truy vấn
                lesson = new Lesson();
                lesson.setIdLesson(resultSet.getString("IdLesson"));
                lesson.setName(resultSet.getString("Name"));
                lesson.setDescription(resultSet.getString("Description"));
                lesson.setStatus(Lesson.LessonStatus.valueOf(resultSet.getString("Status").toLowerCase()));
                lesson.setSerial(resultSet.getInt("Serial"));
            }

            // Đóng các tài nguyên
            //resultSet.close();
            //tatement.close();
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lesson;
    }


}