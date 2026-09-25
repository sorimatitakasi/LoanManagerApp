package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class Service {
	private final List<Task> tasks = new ArrayList<>();
	private int nextId = 1; // 登録するたびに採番する連番ID

	/** Create: 新しい貸付データを登録する */
	public Task addTask(String title, LocalDate lendDate, int lendAmount, LocalDate dueDate) {
		Task task = new Task(nextId, title, lendDate, lendAmount, dueDate);
		tasks.add(task);
		nextId++;
		return task;
	}

	public List<Task> showTasks() {
		return tasks;
	}
}