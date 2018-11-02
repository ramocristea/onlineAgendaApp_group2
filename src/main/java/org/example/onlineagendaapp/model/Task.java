package org.example.onlineagendaapp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.examle.onlineagendaapp.util.NumberGeneratorUtil;

public class Task {
	private static List<Integer> ids = new ArrayList<>();

	private int id;
	private LocalDateTime targetCompletionDate;
	private Priority priority;
	private String description;
	
	public Task() {
		this.id = NumberGeneratorUtil.getNextRandomId();
		ids.add(id);
	};
	
	public Task(LocalDateTime targetCompletionDate, Priority priority, String description) {
		this.id = NumberGeneratorUtil.getNextRandomId();
		ids.add(id);
		this.targetCompletionDate = targetCompletionDate;
		this.priority = priority;
		this.description = description;
	}

	public LocalDateTime getTargetCompletionDate() {
		return targetCompletionDate;
	}

	public void setTargetCompletionDate(LocalDateTime targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((targetCompletionDate == null) ? 0 : targetCompletionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (targetCompletionDate == null) {
			if (other.targetCompletionDate != null)
				return false;
		} else if (!targetCompletionDate.equals(other.targetCompletionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", targetCompletionDate=" + targetCompletionDate + ", priority=" + priority
				+ ", description=" + description + "]";
	}

}
