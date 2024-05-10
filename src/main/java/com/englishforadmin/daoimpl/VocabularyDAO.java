package com.englishforadmin.daoimpl;

import com.englishforadmin.myconnection.MySQLconnection;
import model.Vocabulary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VocabularyDAO{
    final public static String SELECT_ALL_VOCABULARY_IN_LESSON_QUERY =
            "SELECT V.IdVocabulary, V.Word, V.Mean, V.Image, V.Phonetic\n" +
            "FROM VOCABULARY V\n" +
            "INNER JOIN VOCABULARYPART VP ON V.IdVocabulary = VP.IdVocabulary\n" +
            "INNER JOIN LESSONPART LP ON VP.IdLessonPart = LP.IdLessonPart\n" +
            "INNER JOIN LESSON L ON LP.IdLesson = L.IdLesson\n" +
            "WHERE L.IdLesson = ?\n";
    final public static String SELECT_ALL_VOCABULARY_QUERY =
            "SELECT V.IdVocabulary, V.Word, V.Mean, V.Image, V.Phonetic\n" +
                    "FROM VOCABULARY V\n";
    final public static String SELECT_ALL_ANTONYMS_VOCABULARY_QUERY =
            "SELECT V.IdVocabulary, V.Word, V.Mean, V.Image, V.Phonetic " +
                    "FROM VOCABULARY V " +
                    "INNER JOIN ANTONYMS A ON V.IdVocabulary = A.IdAntonyms " +
                    "WHERE A.IdVocabulary = ? " +
                    "UNION ALL " +
                    "SELECT V.IdVocabulary, V.Word, V.Mean, V.Image, V.Phonetic " +
                    "FROM VOCABULARY V " +
                    "INNER JOIN ANTONYMS A ON V.IdVocabulary = A.IdVocabulary " +
                    "WHERE A.IdAntonyms = ?;";
    final public static String SELECT_ALL_SYNONYMS_VOCABULARY_QUERY =
            "SELECT V.IdVocabulary, V.Word, V.Mean, V.Image, V.Phonetic " +
                    "FROM VOCABULARY V " +
                    "INNER JOIN SYNONYMS S ON V.IdVocabulary = S.IdSynonyms " +
                    "WHERE S.IdVocabulary = ? " +
                    "UNION ALL "+
                    "SELECT V.IdVocabulary, V.Word, V.Mean, V.Image, V.Phonetic " +
                    "FROM VOCABULARY V " +
                    "INNER JOIN SYNONYMS S ON V.IdVocabulary = S.IdSynonyms " +
                    "WHERE S.IdSynonyms = ?;";
    private final static String INSERT_VOCABULARY_QUERY =
            "INSERT INTO VOCABULARY (Word, Mean, Phonetic, Image) " +
            "VALUES (?,?,?,?)";
    private final static String UPDATE_VOCABULARY_QUERY =
            "UPDATE VOCABULARY \n" +
            "SET Word = ?, Mean = ?, Phonetic = ?, Image = ?\n" +
            "WHERE IdVocabulary = ?;";
    private final static String SELECT_LATEST_ID_VOCABULARY_QUERY =
            "SELECT IdVocabulary\n" +
                    "FROM VOCABULARY\n" +
                    "ORDER BY IdVocabulary DESC\n" +
                    "LIMIT 1;";
    public boolean insert(Vocabulary entity){
        Connection connection = MySQLconnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VOCABULARY_QUERY)) {
                preparedStatement.setString(1, entity.getWord());
                preparedStatement.setString(2, entity.getMean());
                preparedStatement.setString(3, entity.getPhonetic());
                preparedStatement.setBytes(4, entity.getImage());

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
            }
        }
        return false;
    }

    public boolean update(Vocabulary entity){
        Connection connection = MySQLconnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VOCABULARY_QUERY)) {
                preparedStatement.setString(1, entity.getWord());
                preparedStatement.setString(2, entity.getMean());
                preparedStatement.setString(3, entity.getPhonetic());
                preparedStatement.setBytes(4, entity.getImage());
                preparedStatement.setString(5, entity.getIdVocabulary());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Update successful.");
                    return true;
                } else {
                    System.out.println("Update failed.");
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void delete(String id){

    }

    public Vocabulary selectById(String id){
        return null;
    }

    public List<Vocabulary> selectAll(){
        LinkedList<Vocabulary> lstVocabulary = new LinkedList<>();
        Connection connection = MySQLconnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VOCABULARY_QUERY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Vocabulary vocabulary = new Vocabulary();
                    vocabulary.setIdVocabulary(resultSet.getString("IdVocabulary"));
                    vocabulary.setImage(resultSet.getBytes("Image"));
                    vocabulary.setMean(resultSet.getString("Mean"));
                    vocabulary.setWord(resultSet.getString("Word"));
                    vocabulary.setPhonetic(resultSet.getString("Phonetic"));
                    lstVocabulary.add(vocabulary);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lstVocabulary;
    }

    public List<Vocabulary> selectBySql(String sql, Object...args){
        LinkedList<Vocabulary> lstVocabulary = new LinkedList<>();
        Connection connection = MySQLconnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Vocabulary vocabulary = new Vocabulary();
                    vocabulary.setIdVocabulary(resultSet.getString("IdVocabulary"));
                    vocabulary.setImage(resultSet.getBytes("Image"));
                    vocabulary.setMean(resultSet.getString("Mean"));
                    vocabulary.setWord(resultSet.getString("Word"));
                    vocabulary.setPhonetic(resultSet.getString("Phonetic"));
                    lstVocabulary.add(vocabulary);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lstVocabulary;
    }
    public String getLastestId(){
        Connection connection = MySQLconnection.getConnection();
        String id = "";
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LATEST_ID_VOCABULARY_QUERY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    id = resultSet.getString("IdVocabulary");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (id.isEmpty())
            id = "V000000001";
        return id;
    }
}
