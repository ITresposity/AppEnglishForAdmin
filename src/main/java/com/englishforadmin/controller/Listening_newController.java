package com.englishforadmin.controller;
import com.englishforadmin.MainApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
public class Listening_newController {
    @FXML
    private MFXButton btnAvatar;

    @FXML
    private MFXButton btnCancelNewListening;

    @FXML
    private MFXButton btnChooseVideoListening;

    @FXML
    private Button btnExit;

    @FXML
    private MFXButton btnListening01;

    @FXML
    private MFXButton btnListening02;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnSubmitNewListening;

    @FXML
    private GridPane gridpnListening;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Label lblSourceVideo;

    @FXML
    private Pane pnLessonContent;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnNewLesson;

    @FXML
    private Pane pnTitleNewLesson;

    @FXML
    private Pane pnlVideoSource;

    @FXML
    private TextArea txtareaDescription;

    @FXML
    private TextArea txtareaScript;

    @FXML
    private TextArea txtareaTitleListening;

    @FXML
    void SubmitListening_new(ActionEvent event ) throws IOException
    {
        // nhảy lại form trước
        // load lại list listening ( nội dung vừa edit listening )
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
        }
    }

    @FXML
    void CancelListening_new(ActionEvent event ) throws IOException
    {
        // nhảy lại form trước
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
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
