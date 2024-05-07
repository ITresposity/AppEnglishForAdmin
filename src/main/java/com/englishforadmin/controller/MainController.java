package com.englishforadmin.controller;


import com.englishforadmin.MainApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Lesson;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;


public class MainController
{
    @FXML
    private MFXButton btnAddNewLesson;
    @FXML
    private MFXButton btnAvatar;

    @FXML
    private Button btnExit;

    @FXML
    private MFXButton btnGrammar;

    @FXML
    private MFXButton btnListening;

    @FXML
    private MFXButton btnLogout;

    @FXML
    private MFXButton btnManageLesson;

    @FXML
    private MFXButton btnManageQuiz;

    @FXML
    private MFXButton btnManageVolcabularyStore;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnSpeaking;

    @FXML
    private MFXButton btnVolcabulary;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Pane pnMain;

    @FXML
    private TableView<?> tableViewLesson;



    @FXML
    void ManageLessonScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("", "main.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ManageStoreVocabularyScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/volcabularyStore", "Store_list.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ManageQuizScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/quiz", "Quiz_list.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void AddNewLessonScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/lesson", "Lesson_newB1.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    // after all:
    @FXML
    void ProfileUserScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/", ".fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //
    @FXML
    public void initialize() {

    }

    //--------------------------------------main function----------------------------------------------
    //load lesson
    private void loadLessons(TableView<Lesson> lessonsTableView) throws SQLException {
        List<Lesson> lessons = lessonDAO.getAllLessons();

        // Nếu bạn muốn thực hiện bất kỳ xử lý nào trước khi hiển thị dữ liệu, bạn có thể làm ở đây

        ObservableList<Lesson> lessonObservableList = FXCollections.observableArrayList(lessons);
        lessonsTableView.setItems(lessonObservableList);
    }






}