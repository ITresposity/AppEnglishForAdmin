package com.englishforadmin.controller;

import com.englishforadmin.MainApplication;
import com.englishforadmin.StateManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AnswerQuiz;
import model.QuestionQuiz;

import java.io.IOException;
import java.util.List;

public class Quiz_editAnswerController {

    @FXML
    private ToggleGroup IsCorrectGroupAnswer1;

    @FXML
    private ToggleGroup IsCorrectGroupAnswer2;

    @FXML
    private ToggleGroup IsCorrectGroupAnswer3;

    @FXML
    private ToggleGroup IsCorrectGroupAnswer4;

    @FXML
    private MFXButton btnCancelEditQuizAnswer;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnQuizQuestion01;

    @FXML
    private MFXButton btnQuizQuestion02;

    @FXML
    private MFXButton btnSubmitEditQuizAnswer;

    @FXML
    private MFXButton btnUserInformation;

    @FXML
    private GridPane gridpnQuizQuestion;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Label lblQuestionNumber;

    @FXML
    private Pane pnEditLesson;

    @FXML
    private Pane pnLessonContent;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnTitleEditLessonAnswer;

    @FXML
    private RadioButton rdb01_No;

    @FXML
    private RadioButton rdb01_Yes;
    @FXML
    private RadioButton rdb02_No;

    @FXML
    private RadioButton rdb02_Yes;

    @FXML
    private RadioButton rdb03_No;

    @FXML
    private RadioButton rdb03_Yes;

    @FXML
    private RadioButton rdb04_No;

    @FXML
    private RadioButton rdb04_Yes;

    @FXML
    private AnchorPane scrollpanelMain;

    @FXML
    private TextArea txtareaAnswer01;

    @FXML
    private TextArea txtareaAnswer02;

    @FXML
    private TextArea txtareaAnswer03;

    @FXML
    private TextArea txtareaAnswer04;

    // fixing
    @FXML
    void SubmitQuizAnswer_edit(ActionEvent event) throws IOException {
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuiz.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelQuizAnswer_edit(ActionEvent event) throws IOException {
        //  // hủy hẳn luôn : -> Quiz_newQuiz
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuiz.fxml");
        } catch (IOException e) {
            e.printStackTrace();
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
    //

    // ----------------------------main function -----------------------------------------------------------------

    @FXML
    public void initialize() {

        rdb01_Yes.setToggleGroup(IsCorrectGroupAnswer1);
        rdb01_No.setToggleGroup(IsCorrectGroupAnswer1);

        rdb02_Yes.setToggleGroup(IsCorrectGroupAnswer2);
        rdb02_No.setToggleGroup(IsCorrectGroupAnswer2);

        rdb03_Yes.setToggleGroup(IsCorrectGroupAnswer3);
        rdb03_No.setToggleGroup(IsCorrectGroupAnswer3);

        rdb04_Yes.setToggleGroup(IsCorrectGroupAnswer4);
        rdb04_No.setToggleGroup(IsCorrectGroupAnswer4);
        displayQuestionAndAnswers();



    }


    private void displayQuestionAndAnswers() {
        QuestionQuiz question = StateManager.getCurrentQuestion();
        if (question != null) {
            List<AnswerQuiz> answerList = question.getLstAnswers();
            if (answerList != null && !answerList.isEmpty()) {
                lblQuestionNumber.setText(String.valueOf(question.getSerial()));
                txtareaAnswer01.setText(answerList.get(0).getContent());
                txtareaAnswer02.setText(answerList.get(1).getContent());
                txtareaAnswer03.setText(answerList.get(2).getContent());
                txtareaAnswer04.setText(answerList.get(3).getContent());

                // Xử lý giá trị của RadioButton dựa trên đối tượng AnswerQuiz
                handleRadioButtonValues(answerList);
            }
        }
    }

    private void handleRadioButtonValues(List<AnswerQuiz> answerList) {
        setSelectedRadioButton(IsCorrectGroupAnswer1, answerList.get(0).isCorrect());
        setSelectedRadioButton(IsCorrectGroupAnswer2, answerList.get(1).isCorrect());
        setSelectedRadioButton(IsCorrectGroupAnswer3, answerList.get(2).isCorrect());
        setSelectedRadioButton(IsCorrectGroupAnswer4, answerList.get(3).isCorrect());
    }

    private void setSelectedRadioButton(ToggleGroup toggleGroup, boolean isCorrect) {
        RadioButton selectedRadioButton = null;
        if (isCorrect) {
            selectedRadioButton = (RadioButton) toggleGroup.getToggles().get(0);
        } else {
            selectedRadioButton = (RadioButton) toggleGroup.getToggles().get(1);
        }
        selectedRadioButton.setSelected(true);
    }

}
