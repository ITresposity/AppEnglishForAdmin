package com.englishforadmin.controller;
import com.englishforadmin.MainApplication;
import com.englishforadmin.StateManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Quiz;

import java.io.IOException;

public class Quiz_editQuizController {
    @FXML
    private MFXButton btnAvatar;

    @FXML
    private MFXButton btnCancelEditQuiz;

    @FXML
    private MFXButton btnEditQuestionQuiz;

    @FXML
    private MFXButton btnEdit_CreateQuizQuestion;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnSubmitEditQuiz;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Pane pnDataLesson;

    @FXML
    private Pane pnMain;

    @FXML
    private MFXRadioButton rdbBlockQuiz;

    @FXML
    private MFXRadioButton rdbOpenQuiz;

    @FXML
    private TextField txtOrderQuiz;

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
    void SubmitQuiz_edit(ActionEvent event ) throws IOException
    {
        // load quiz list  + add/edit quiz
        try {
            MainApplication.loadForm("/quiz", "Quiz_list.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelQuiz_edit(ActionEvent event ) throws IOException
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
        Quiz quiz = StateManager.getCurrentQuiz();
        if ( quiz != null)
        {
            txtOrderQuiz.setText(quiz.getIdQuiz());
            txtOrderQuiz.setEditable(false);
            txtTitleQuiz.setText(quiz.getTitle());
        }

    }
}
