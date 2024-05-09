package com.englishforadmin.daoimpl;

import com.englishforadmin.myconnection.MySQLconnection;
import model.Grammar;
import model.GrammarPart;
import model.LessonPart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LessonPartDAO {
    private final static String INSERT_LESSONPART_QUERY =
            "INSERT INTO LESSONPART (Type, IdLesson) " +
                    "VALUES (?,?)";
    public boolean insert(LessonPart entity){
        Connection connection = MySQLconnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LESSONPART_QUERY)) {
                preparedStatement.setString(1, entity.getType().toString().toLowerCase());
                preparedStatement.setString(2, entity.getIdLesson());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Insertion successful.");
                    return true;
                } else {
                    System.out.println("Insertion failed.");
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
