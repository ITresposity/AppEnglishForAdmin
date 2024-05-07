package com.englishforadmin.controller;

import com.englishforadmin.StateManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.englishforadmin.MainApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRadioButton;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Lesson;

import java.io.IOException;

public class Lesson_editB1Controller {
    @FXML
    private MFXButton btnCancel;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnNext;

    @FXML
    private MFXButton btnUserInformation;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Pane pnLessonContent;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnNewLesson;

    @FXML
    private Pane pnTitleNewLesson;

    @FXML
    private MFXRadioButton rdbLockLesson;

    @FXML
    private MFXRadioButton rdbOpenLesson;

    @FXML
    private TextField txtNameLesson;

    @FXML
    private TextArea txtareaDescription;

    @FXML
    void CancelLesson_editB1(ActionEvent event ) throws IOException
    {
        // nhảy lại form trước
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
        }
    }
    @FXML
    void Lesson_editB2Screen(ActionEvent event ) throws IOException
    {
        // submit lesson next B1
        try {
            MainApplication.loadForm("/lesson", "Lesson_editB2.fxml");
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
        // Load dữ liệu từ đối tượng Lesson đã chọn
        Lesson lesson = StateManager.getCurrentLesson();
        if (lesson != null) {
            txtNameLesson.setText(lesson.getName());
            txtareaDescription.setText(lesson.getDescription());
        }



    }

}
