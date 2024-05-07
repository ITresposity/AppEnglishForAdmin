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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Quiz_editAnswerController {

    @FXML
    private MFXButton btnCancelEditQuizAnswer;

    @FXML
    private MFXButton btnChooseImg01;

    @FXML
    private MFXButton btnChooseImg02;

    @FXML
    private MFXButton btnChooseImg03;

    @FXML
    private MFXButton btnChooseImg04;

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
    private Label lblImageSource03;

    @FXML
    private Label lblImageSource04;

    @FXML
    private Label lblQuestionNumber;

    @FXML
    private Label lblSourceImg01;

    @FXML
    private Label lblSourceImg02;

    @FXML
    private Pane pnEditLesson;

    @FXML
    private Pane pnImageSource;

    @FXML
    private Pane pnImageSource04;

    @FXML
    private Pane pnImageSource1;

    @FXML
    private Pane pnImageSource11;

    @FXML
    private Pane pnLessonContent;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnTitleEditLessonAnswer;

    @FXML
    private MFXRadioButton rdb01_No;

    @FXML
    private MFXRadioButton rdb01_No1;

    @FXML
    private MFXRadioButton rdb01_Yes;

    @FXML
    private MFXRadioButton rdb01_Yes1;

    @FXML
    private MFXRadioButton rdb02_No;

    @FXML
    private MFXRadioButton rdb02_Yes;

    @FXML
    private MFXRadioButton rdb03_No;

    @FXML
    private MFXRadioButton rdb03_Yes;

    @FXML
    private MFXRadioButton rdb04_No;

    @FXML
    private MFXRadioButton rdb04_Yes;

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
    void SubmitQuizAnswer_edit(ActionEvent event ) throws IOException
    {
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuiz.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelQuizAnswer_edit(ActionEvent event ) throws IOException
    {
        //  // hủy hẳn luôn : -> Quiz_newQuiz
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuiz.fxml");
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
