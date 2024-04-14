package com.englishforadmin.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class MainController {

    @FXML
    private HBox HBoxHeader;

    public void initialize() {
        HBoxHeader.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        HBoxHeader.toBack();
    }


}