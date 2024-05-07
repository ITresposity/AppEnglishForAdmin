package com.englishforadmin.controller;

import com.englishforadmin.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Store_listController {

    @FXML
    private MFXButton btnAddNewVolcabulary;

    @FXML
    private Button btnExit;

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
    private MFXButton btnSearchVolcabulary;

    @FXML
    private MFXButton btnUserInformation;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Pane pnMain;

    @FXML
    private ScrollPane pnMainVolcabulary;

    @FXML
    private TextField txtSearchVolcabulary;

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
    void AddNewVolcabularyScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/volcabulary", "Volcabulary_new.fxml");
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
}
