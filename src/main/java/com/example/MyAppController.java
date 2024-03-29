package com.example;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyAppController {

    @FXML
    private VBox layout;

    @FXML
    private Button outputBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private TextField tField;

    @FXML
    private VBox textFieldList;

    public void initialize() {
    	ObservableList<Node> model = textFieldList.getChildren();
		model.addListener((ListChangeListener.Change<? extends Node> c) -> System.out.println("リストが変更されました"));
		
		tField.setOnAction(e -> {
			model.add(new TextField(tField.getText()));
			tField.clear();
		});

		outputBtn.setOnAction(e -> model.forEach(node -> System.out.println(((TextField) node).getText())));
		
		removeBtn.setOnAction(e -> {
			if (model.size() > 0)
				model.remove(model.size()-1);
		});
    }
}
