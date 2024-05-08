package com.englishforadmin.controller;

import com.englishforadmin.MainApplication;
import com.englishforadmin.StateManager;
import com.englishforadmin.dao.QuestionQuizDAO;
import com.englishforadmin.daoimpl.QuestionQuizDAOimpl;
import com.englishforadmin.myconnection.MySQLconnection;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.skins.MFXToggleButtonSkin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.QuestionQuiz;
import model.Quiz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
    private RadioButton rdbBlockQuiz;

    @FXML
    private RadioButton rdbOpenQuiz;

    @FXML
    private TextField txtOrderQuiz;

    @FXML
    private TextField txtTitleQuiz;


    @FXML
    void editQuestionScreen(ActionEvent event) throws IOException {
        // if Question!= null -> button private MFXButton btnOpenEditQuiz enable
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuestion.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddNewQuestionScreen(ActionEvent event) throws IOException {
        try {
            MainApplication.loadForm("/quiz", "Quiz_newQuestion.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void SubmitQuiz_edit(ActionEvent event) throws IOException {
        // load quiz list  + add/edit quiz
        try {
            MainApplication.loadForm("/quiz", "Quiz_list.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelQuiz_edit(ActionEvent event) throws IOException {
        try {
            MainApplication.loadForm("/quiz", "Quiz_list.fxml");
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

    //--------------------------------------main function----------------------------------------------


    // fix toggle Group radio button
    @FXML
    private ToggleGroup radioGroupQuiz = new ToggleGroup();

    // add gridpane auto-create Question
    @FXML
    private FlowPane gridPaneQuestionQuiz;
    private QuestionQuizDAOimpl questionQuizDAOimpl;
    Quiz quiz = StateManager.getCurrentQuiz();

    @FXML
    private void handleButtonActionEditQuestion(QuestionQuiz question) {
        StateManager.setCurrentQuestion(question);
        try {
            MainApplication.loadForm("/quiz", "Quiz_editQuestion.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void EditQuiz(Quiz quizEdit)
    {
        quizEdit = quiz;
        if ( quiz != null )
        {
            String titleQuiz = txtTitleQuiz.getText();
        }




    }


    @FXML
    public void initialize() {

        if (quiz != null) {
            String quizID = quiz.getIdQuiz();
            rdbOpenQuiz.setToggleGroup(radioGroupQuiz);
            rdbBlockQuiz.setToggleGroup(radioGroupQuiz);

            questionQuizDAOimpl = new QuestionQuizDAOimpl(MySQLconnection.getConnection());

            List<QuestionQuiz> questionQuizzes;
            try {
                questionQuizzes = questionQuizDAOimpl.getAllQuestionByQuizID(quizID);
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            int numberOfQuestions = questionQuizzes.size();
            double prefWrapLength = calculatePrefWrapLength();

            gridPaneQuestionQuiz.setHgap(10);
            gridPaneQuestionQuiz.setVgap(10);
            gridPaneQuestionQuiz.setPadding(new Insets(10));
            gridPaneQuestionQuiz.setPrefWrapLength(prefWrapLength);

            for (int i = 0; i < numberOfQuestions; i++) {
                final QuestionQuiz question = questionQuizzes.get(i); // Sử dụng final để giữ giá trị của question
                Button button = new Button(" " + (i + 1) + " ");
                GridPane.setMargin(button, new Insets(15));
                button.setOnAction(event -> handleButtonActionEditQuestion(question));
                gridPaneQuestionQuiz.getChildren().add(button);
            }


            txtOrderQuiz.setText(quiz.getIdQuiz());
            txtOrderQuiz.setEditable(false);
            txtTitleQuiz.setText(quiz.getTitle());

            if (quiz.getStatus() == Quiz.QuizStatus.unlock) {
                rdbOpenQuiz.setSelected(true);
            } else if (quiz.getStatus() == Quiz.QuizStatus.lock) {
                rdbBlockQuiz.setSelected(true);
            }


        }
    }
    private double calculatePrefWrapLength() {
        int numberOfColumns = 2;
        double columnWidth = 100;
        double hGap = 10;
        double prefWrapLength = numberOfColumns * (columnWidth + hGap);
        return prefWrapLength;
    }


}

