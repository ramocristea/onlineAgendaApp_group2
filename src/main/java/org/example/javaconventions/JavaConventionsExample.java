package org.example.javaconventions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.examle.onlineagendaapp.TaskComparator;
import org.example.onlineagendaapp.model.OnlineAgenda;
import org.example.onlineagendaapp.model.Priority;
import org.example.onlineagendaapp.model.Task;

public class JavaConventionsExample {
	
	private static OnlineAgenda onlineAgenda;
	
	public static void main(String[] args) {
		createAgenda();
		printAllTasksFromAgenda();
		
		System.out.println("-----------------------------");
		
		createTaskAndAddToAgenda(LocalDateTime.of(2018, 7, 5, 17, 50), "New Tasks for today", Priority.IMPORTANT);
		createTaskAndAddToAgenda(LocalDateTime.of(2018, 7, 5, 19, 50), "New Tasks for today 2", Priority.IMPORTANT);
		
		printAllTasksFromAgenda();
		
		System.out.println("-----------------------------");
		
		groupTasksByPrioritySortAndPrintTasksForToday();
	}

	private static void createAgenda() {
		onlineAgenda = new OnlineAgenda();
		LocalDateTime today = LocalDateTime.now();
		
		createTaskAndAddToAgenda(today.minusDays(1), "Yesterday's Tasks", Priority.URGENT);
		createTaskAndAddToAgenda(today, "Today's Tasks", Priority.TRIVIAL);
		createTaskAndAddToAgenda(today.plusDays(1), "Tomorrow's Tasks", Priority.IMPORTANT);
	}
	
	private static void printAllTasksFromAgenda() {
		for (Task task : onlineAgenda.getTasks()) {
			System.out.println(task);
		}
	}

	private static void createTaskAndAddToAgenda(LocalDateTime targetCompletionDate, String description, Priority priority) {
		Task tomorrowTask = new Task(targetCompletionDate, priority, description);
		onlineAgenda.getTasks().add(tomorrowTask);
	}

	private static void deleteTaskFromAgenda(int id) {
		Iterator<Task> iterator = onlineAgenda.getTasks().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
				return;
			}
		}
	}

	private static void updateTaskPriority(int id, Priority newPriority) {
		for (Task task : onlineAgenda.getTasks()) {
			if (task.getId() == id) {
				task.setPriority(newPriority);
				onlineAgenda.getTasks().remove(task);
				return;
			}
		}
	}

	private static void groupTasksByPrioritySortAndPrintTasksForToday() {
		List<Task> urgentTasks = new ArrayList<>();
		List<Task> importantTasks = new ArrayList<>();
		List<Task> trivialTasks = new ArrayList<>();
		
		for (Task task : onlineAgenda.getTasks()) {
			if (LocalDate.now().isEqual(task.getTargetCompletionDate().toLocalDate())) {
				switch (task.getPriority()) {
				case URGENT:
					urgentTasks.add(task);
					break;
				case IMPORTANT:
					importantTasks.add(task);
					break;
				case TRIVIAL:
					trivialTasks.add(task);
					break;
				}
			}
		}
		
		TaskComparator taskComparator = new TaskComparator();
		
		Collections.sort(urgentTasks, taskComparator);
		
		Collections.sort(urgentTasks, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
				}
				return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
		});
		
		System.out.println("URGENT tasks for today:");
		if (CollectionUtils.isEmpty(urgentTasks)) {
			System.out.println("You have no URGENT tasks");
		} else {
			for (Task Tasks : urgentTasks) {
				System.out.println(Tasks.toString());
			}
		}
		
		Collections.sort(importantTasks, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
				}
				return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
		});
		
		System.out.println("-----------------------------");
		
		System.out.println("IMPORTANT tasks for today:");
		if (CollectionUtils.isEmpty(importantTasks)) {
			System.out.println("You have no IMPORTANT tasks");
		}

		else {
			for (Task task : importantTasks) {
				System.out.println(task.toString());
			}
		}
		
		Collections.sort(trivialTasks, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
				}
				return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
		});
		
		System.out.println("-----------------------------");
		System.out.println("TRIVIAL tasks for today:");
		if (CollectionUtils.isEmpty(trivialTasks)) {
			System.out.println("You have no TRIVIAL tasks");
		} else {
			for (Task task : trivialTasks) {
				System.out.println(task.toString());
			}
		}

	}

}
