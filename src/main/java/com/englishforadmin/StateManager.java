package com.englishforadmin;

import model.Lesson;

public class StateManager {
    private static Lesson currentLesson;

    public static void setCurrentLesson(Lesson lesson) {
        currentLesson = lesson;
    }

    public static Lesson getCurrentLesson() {
        return currentLesson;
    }
}
