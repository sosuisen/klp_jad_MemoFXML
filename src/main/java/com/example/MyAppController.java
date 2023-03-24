package com.example;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyAppController {
	private ObservableList<Node> model;

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

	private void addItem(String txt) {
		model.add(new TextField(txt));
	}
	
    public void initialize() {
		tField.setOnAction(e -> {
			addItem(tField.getText());
			tField.clear();
		});

		outputBtn.setOnAction(e -> model.forEach(node -> System.out.println(((TextField) node).getText())));

		removeBtn.setOnAction(e -> {
			if (model.size() > 0)
				model.remove(model.size()-1);
		});

		model = textFieldList.getChildren();
		model.addListener((ListChangeListener.Change<? extends Node> c) -> {
			System.out.println("リストが変更されました");
		});
    }
}
