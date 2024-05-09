package com.englishforadmin.controller;
import com.englishforadmin.MainApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Quiz_newQuizController {
    @FXML
    private MFXButton btnCancelNewQuiz;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnNewQuiz_final;

    @FXML
    private MFXButton btnOpenEditQuiz;

    @FXML
    private MFXButton btnOpen_AddQuestionQuiz;

    @FXML
    private MFXButton btnQuizQuestion01;

    @FXML
    private MFXButton btnQuizQuestion02;

    @FXML
    private MFXButton btnUserInformation;

    @FXML
    private GridPane gridpnQuizQuestion;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Pane pnDataLesson;

    @FXML
    private Pane pnMain;

    @FXML
    private RadioButton rdbHiddenQuiz;

    @FXML
    private RadioButton rdbLockQuiz;

    @FXML
    private RadioButton rdbOpenQuiz;

    @FXML
    private TextField txtOrder;

    @FXML
    private TextField txtTitleQuiz;

    @FXML
    void editQuestionScreen(ActionEvent event ) throws IOException
    {
        // if Question!= null -> button private MFXButton btnOpenEditQuiz enable
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuestion.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddNewQuestionScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/quiz", "Quiz_newQuestion.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void SubmitQuiz_new(ActionEvent event ) throws IOException
    {
        // load quiz list  + add quiz
        try {
            MainApplication.loadForm("/quiz", "Quiz_list.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelQuiz_new(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/quiz", "Quiz_list.fxml");
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
