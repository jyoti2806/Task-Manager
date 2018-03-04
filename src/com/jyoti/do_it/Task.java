package com.jyoti.do_it;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class Task {

/*public static void main(String[] args) {
		//Practising binding
		SimpleIntegerProperty siInt = new SimpleIntegerProperty();
		siInt.set(45);
		System.out.println(siInt.get());
		ReadOnlyIntegerWrapper readOnlyIntegerWrapper = new ReadOnlyIntegerWrapper(98);
		ReadOnlyIntegerProperty roInt = readOnlyIntegerWrapper.getReadOnlyProperty();
		System.out.println(roInt.get());
		readOnlyIntegerWrapper
				.set(100);
		System.out.println(roInt.get());
		siInt.addListener(new ChangeListener<Number>() {   // Listener is called everytime value of siInt is changed
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(oldValue + "-->" + newValue);
			}
		});
		siInt.set(78);
		siInt.set(32);
	}*/
	private final StringProperty priority = new SimpleStringProperty();
	private final StringProperty description = new SimpleStringProperty();
	private final ObjectProperty<Integer> progress = new SimpleObjectProperty<>(0);
	private final ObjectProperty<Integer> id = new SimpleObjectProperty<>(null);


	public Task() {
	}
	public Task(Integer id,String priority,String description,Integer progress){
		this.setId(id);
		this.setPriority(priority);
		this.setDescription(description);
		this.setProgress(progress);
	}

	public Integer getId() {
		return id.get();
	}

	public ObjectProperty<Integer> idProperty() {
		return id;
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public String getPriority() {
		return priority.get();
	}

	public StringProperty priorityProperty() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority.set(priority);
	}

	public String getDescription() {
		return description.get();
	}

	public StringProperty descriptionProperty() {
		return description;
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public Integer getProgress() {
		return progress.get();
	}

	public ObjectProperty<Integer> progressProperty() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress.set(progress);
	}
}
