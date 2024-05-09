package com.englishforadmin.controller;
import com.englishforadmin.MainApplication;
import com.englishforadmin.StateManager;
import com.englishforadmin.daoimpl.GrammarDAO;
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
import model.Grammar;
import model.Lesson;


import java.io.IOException;
import java.util.List;

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
    @FXML
    private GridPane gridpnGrammar;
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
    List<Grammar> lstGrammar;
    GrammarDAO grammarDAO;
    Grammar curGrammar;
    Lesson lesson;
    byte[] dataImage;
    @FXML
    public void initialize() {
        lesson = StateManager.getCurrentLesson();
        grammarDAO = new GrammarDAO();
        lstGrammar = grammarDAO.selectBySql(GrammarDAO.SELECT_ALL_GRAMMAR_IN_LESSON_QUERY, lesson.getIdLesson());
    }

    private void loadGridPane(){
        gridpnGrammar.getChildren().clear();
        if(lstGrammar.isEmpty())
            return;
        int numGrammar = lstGrammar.size();
        int maxColumns = 2;
        int rowCount = (int) Math.ceil((double) numGrammar / maxColumns);
        int index = 0;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < maxColumns; col++) {
                if (index < numGrammar) {
                    MFXButton button = new MFXButton(String.valueOf(index));
                    int currentIndex = index;
                    button.setOnAction(e -> {
                        loadDataToFeild(currentIndex);
                    });

                    GridPane.setRowIndex(button, row);
                    GridPane.setColumnIndex(button, col);

                    gridpnGrammar.getChildren().add(button);
                    index++;
                }
            }
        }
    }

    private void loadDataToFeild(int index){
        curGrammar = lstGrammar.get(index);

        txtareaTitle.setText(curGrammar.getTitle());
        txtareaContent.setText(curGrammar.getContent());
        txtareaRuleGrammar.setText(curGrammar.getRule());
        txtareaExampleGrammar.setText(curGrammar.getExample());
        dataImage = curGrammar.getImage();
    }
}
