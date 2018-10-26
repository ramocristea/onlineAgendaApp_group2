package org.example.onlineagendaapp.model;

import java.util.ArrayList;
import java.util.List;

public class OnlineAgenda {

	private List<Tasks> tasks;

	public List<Tasks> getTasks() {
		if (tasks == null) {
			tasks = new ArrayList<Tasks>();
		}
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

}
