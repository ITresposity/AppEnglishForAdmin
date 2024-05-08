package com.englishforadmin;

import model.Lesson;
import model.QuestionQuiz;
import model.Quiz;

public class StateManager {
    private static Lesson currentLesson;
    private static Quiz currentQuiz;
    private static QuestionQuiz currentQuestion;

    public static void setCurrentLesson(Lesson lesson) {
        currentLesson = lesson;
    }

    public static Lesson getCurrentLesson() {
        return currentLesson;
    }
    public static void setCurrentQuiz(Quiz quiz) {
        currentQuiz = quiz;
    }

    public static Quiz getCurrentQuiz() {
        return currentQuiz;
    }
    public static void setCurrentQuestion(QuestionQuiz question) {
        currentQuestion = question;
    }

    public static QuestionQuiz getCurrentQuestion() {
        return currentQuestion;
    }
}
