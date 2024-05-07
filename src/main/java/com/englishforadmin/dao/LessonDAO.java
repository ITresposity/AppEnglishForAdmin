package com.englishforadmin.dao;

import model.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDAO {
    private Connection connection;

    public LessonDAO(Connection connection) {
        this.connection = connection;
    }

    // Phương thức để lấy danh sách tất cả các bài học từ cơ sở dữ liệu
    public List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();

        String query = "SELECT * FROM lesson";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setIdLesson(resultSet.getString("IdLesson"));
                lesson.setName(resultSet.getString("Name"));
                lesson.setDescription(resultSet.getString("Description"));
                lesson.setSerial(resultSet.getInt("Serial"));
                lesson.setStatus(Lesson.LessonStatus.valueOf(resultSet.getString("Status").toUpperCase()));

                lessons.add(lesson);
            }
        }

        return lessons;
    }
}
