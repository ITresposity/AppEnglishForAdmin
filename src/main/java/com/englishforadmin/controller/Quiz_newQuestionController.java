package com.englishforadmin.controller;

import com.englishforadmin.MainApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Quiz_newQuestionController {


    @FXML
    private MFXButton btnSubmitNewQuestion;
    @FXML
    private MFXButton btnCancelNewQuizQuestion;

    @FXML
    private MFXButton btnChooseImgQuiz;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnNext;

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
    private Label lblImageSource;

    @FXML
    private Label lblQuizQuestioNumber;

    @FXML
    private Pane pnImageSource;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnNewLesson;

    @FXML
    private Pane pnQuizContent;

    @FXML
    private Pane pnTitleNewLesson;

    @FXML
    private TextArea txtareaContent;

    // fixing
    @FXML
    void Quiz_newAnswerScreen(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/quiz", "Quiz_newAnswer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void CancelQuiz_newQuestion(ActionEvent event ) throws IOException
    {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
        }

    }

    @FXML
    void SubmitQuiz_newQuestion(ActionEvent event ) throws IOException
    {
        // submit new question


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
