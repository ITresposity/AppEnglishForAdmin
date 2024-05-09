package com.englishforadmin.controller;
import com.englishforadmin.MainApplication;
import com.englishforadmin.StateManager;
import com.englishforadmin.daoimpl.GrammarDAO;
import com.englishforadmin.feature.MessageBox;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Grammar;
import model.GrammarPart;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Grammar_newController {
    @FXML
    private MFXButton btn;

    @FXML
    private MFXButton btnCancelNewGrammar;

    @FXML
    private MFXButton btnChooseImg;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMaximise;

    @FXML
    private Button btnMinimise;

    @FXML
    private MFXButton btnSubmitNewGrammar;

    @FXML
    private MFXButton btnUserInformation;

    @FXML
    private GridPane gridpnGrammar;

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
    private Pane pnTitleNewLesson;

    @FXML
    private TextArea txtareaContent;

    @FXML
    private TextArea txtareaExample;

    @FXML
    private TextArea txtareaRule;

    @FXML
    private TextArea txtareaTitle;

    byte[] imgData;
    GrammarDAO grammarDAO;
    // fixing
    @FXML
    void SubmitGrammar_new(ActionEvent event ) throws IOException
    {
        btnChooseImg.setOnAction(event1 -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Image File");
            File selectedFile = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());

            if (selectedFile != null) {
                try {
                    imgData = convertImageToBase64(selectedFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        if(checkMissData()){
            MessageBox.show("Lỗi","Hãy điền đầy đủ thông tin trước khi tiếp tục", Alert.AlertType.ERROR);
            return;
        }
        addNewGrammar();

        // nhảy lại form trước
        // load lại list grammar + số lượng grammar
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene previousScene = MainApplication.getPreviousScene();
        if (previousScene != null) {
            currentStage.setScene(previousScene);
        }
    }

    @FXML
    void CancelGrammar_new(ActionEvent event ) throws IOException
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
        grammarDAO = new GrammarDAO();
    }

    private boolean checkMissData(){
        return txtareaTitle.getText().isEmpty() || txtareaContent.getText().isEmpty()
                || txtareaRule.getText().isEmpty() || txtareaExample.getText().isEmpty();
    }

    private byte[] convertImageToBase64(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            return inputStream.readAllBytes();
        }
    }

    private boolean addNewGrammar(){
        Grammar grammar = new Grammar();
        grammar.setTitle(txtareaTitle.getText());
        grammar.setContent(txtareaContent.getText());
        grammar.setExample(txtareaExample.getText());
        grammar.setRule(txtareaRule.getText());
        grammar.setImage(imgData);
        grammarDAO.insert(grammar);
        grammar.setIdGrammar(grammarDAO.getLastestId());
        GrammarPart part = new GrammarPart();
        part.setIdGrammar(grammar.getIdGrammar());

        return true;
    }
}
