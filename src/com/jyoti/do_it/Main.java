package com.jyoti.do_it;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = FXMLLoader.load(getClass().getResource("simpleUi.fxml"));
		primaryStage.setTitle("Do-It!!");
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
