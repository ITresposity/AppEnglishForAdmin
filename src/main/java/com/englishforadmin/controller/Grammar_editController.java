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

public class Grammar_editController {
    @FXML
    private MFXButton btnCancelEditGrammar;

    @FXML
    private MFXButton btnChooseImage_grammar;

    @FXML
    private Button btnExit;

    @FXML
    private MFXButton btnGrammar01;

    @FXML
    private MFXButton btnGrammar02;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnSubmitEditGrammar;

    @FXML
    private MFXButton btnUserInformation;

    @FXML
    private GridPane gridpnGrammar_edit;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Label lblImageSource;

    @FXML
    private Pane pnImageSource;

    @FXML
    private Pane pnLessonContent;

    @FXML
    private Pane pnMain;

    @FXML
    private Pane pnNewLesson;

    @FXML
    private TextArea txtareaContent;

    @FXML
    private TextArea txtareaExampleGrammar;

    @FXML
    private TextArea txtareaRuleGrammar;

    @FXML
    private TextArea txtareaTitle;


    // fixing
    @FXML
    void SubmitGrammar_edit(ActionEvent event ) throws IOException
    {
        // nhảy lại form trước
        // load lại list grammar ( nội dung vừa edit grammar )
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
        }
    }

    @FXML
    void CancelGrammar_edit(ActionEvent event ) throws IOException
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
