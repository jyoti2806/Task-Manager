package com.jyoti.do_it;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public TableView taskTable;
	@FXML
	public ComboBox priority;
	@FXML
	public Spinner progressSpinner;
	@FXML
	public TextField tasksDescription;
	@FXML
	public Button addBtn;
	@FXML
	public Button cancelBtn;
	@FXML
	public CheckBox completedCheckBox;
	@FXML
	public ProgressBar progressBar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		priority.getItems().addAll("High", "Medium", "Low");
		progressSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
		/*progressSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
			if (((int)newValue) == 100){
				completedCheckBox.setSelected(true);
			}
			else completedCheckBox.setSelected(false);
			progressBar.setProgress(1.0 * (int)newValue/100);
			System.out.println(1.0 * (int)newValue/100);
		});*/
		progressSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue observable, Integer oldValue, Integer newValue) {
				if (((int) newValue) == 100) {
					completedCheckBox.setSelected(true);
				} else completedCheckBox.setSelected(false);
				progressBar.setProgress(newValue.doubleValue() / 100);
			}
		});
	}
}
