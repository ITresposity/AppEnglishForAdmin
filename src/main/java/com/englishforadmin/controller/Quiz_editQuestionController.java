package com.englishforadmin.controller;

import com.englishforadmin.MainApplication;
import com.englishforadmin.StateManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AnswerQuiz;
import model.QuestionQuiz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;


public class Quiz_editQuestionController {
    public ImageView imgView;
    @FXML
    private MFXButton btnCancelEditQuizQuestion;

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
    private Pane pnEditLessonQuestion;

    @FXML
    private Pane pnImageSource;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnQuizContent;

    @FXML
    private Pane pnTitleEditLessonQuestion;

    @FXML
    private TextArea txtareaContent;

    // fixing
    @FXML
    void Quiz_editAnswerScreen(ActionEvent event) throws IOException {
        // next
        try {
            MainApplication.loadForm("/quiz", "Quiz_editAnswer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelQuizAnswer_edit(ActionEvent event) throws IOException {
        // nhảy lại form trước
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
        }
    }

    // after all:
    @FXML
    void ProfileUserScreen(ActionEvent event) throws IOException {
        try {
            MainApplication.loadForm("/", ".fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // update Question quiz
    QuestionQuiz question = StateManager.getCurrentQuestion();


    @FXML
    public void initialize() {
        if (question != null) {
            txtareaContent.setText(question.getContent());
            lblQuizQuestioNumber.setText(String.valueOf(question.getSerial()));
            lblImageSource.setText(Arrays.toString(question.getImage()));
            InputStream is = new ByteArrayInputStream(question.getImage());
            Image image = new Image(is);
            imgView.setImage(image);
        } else {
            System.out.println("Dữ liệu gặp lỗi");
        }
    }
}
