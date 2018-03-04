package com.jyoti.do_it;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	private final Task currentTask = new Task();
	private final ObservableList<Task> tasks = FXCollections.observableArrayList();

	@FXML
	private TableView<Task> taskTable;
	@FXML
	private TableColumn<Task,String> priorityColumn;
	@FXML
	private TableColumn<Task,String> descriptionColumn;
	@FXML
	private TableColumn<Task,String> progressColumn;
	@FXML
	private ComboBox priority;
	@FXML
	private Spinner progressSpinner;
	@FXML
	private TextField tasksDescription;
	@FXML
	private Button addBtn;
	@FXML
	private Button cancelBtn;
	@FXML
	private CheckBox completedCheckBox;
	@FXML
	private ProgressBar progressBar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		priority.getItems().addAll("High", "Medium", "Low");
		progressSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
		progressSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue observable, Integer oldValue, Integer newValue) {
				if (((int) newValue) == 100) {
					completedCheckBox.setSelected(true);
				} else completedCheckBox.setSelected(false);
			//	progressBar.setProgress(newValue.doubleValue() / 100); // can be done this way
				/*System.out.println(currentTask.getPriority());
				System.out.println(currentTask.getDescription());
				System.out.println(currentTask.getProgress());*/
				tasks.add(new Task(2+newValue,"Medium","New Task "+(2+newValue),newValue));
			}
		});

		IntegerProperty intProgress = new SimpleIntegerProperty();
		intProgress.bind(progressSpinner.valueProperty());
		progressBar.progressProperty().bind(intProgress.divide(100.0)); // dynamic binding

		priority.valueProperty().bindBidirectional(currentTask.priorityProperty());
		progressSpinner.getValueFactory().valueProperty().bindBidirectional(currentTask.progressProperty());
		tasksDescription.textProperty().bindBidirectional(currentTask.descriptionProperty());

		tasks.addAll(new Task(0,"High","Android Associate Developer Course", 20),
				new Task(1,"Medium","JavaFx Applications",70),
				new Task(2,"Low","Javascript Tutorial",30));
		taskTable.setItems(tasks);

		priorityColumn.setCellValueFactory(rowData->rowData.getValue().priorityProperty());
		descriptionColumn.setCellValueFactory(rowData->rowData.getValue().descriptionProperty());
		progressColumn.setCellValueFactory(rowData-> Bindings.concat(rowData.getValue().progressProperty(),"%"));

		taskTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
			@Override
			public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
				selectedTask(newValue);
			}
		});

	}

	private void selectedTask(Task selectedTask) {
		if (selectedTask!=null){
			currentTask.setPriority(selectedTask.getPriority());
			currentTask.setDescription(selectedTask.getDescription());
			currentTask.setProgress(selectedTask.getProgress());
		}
	}
}
