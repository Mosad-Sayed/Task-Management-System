package com.taskmanager.task_management_system.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Title must not be empty")
	@Size(max = 255, message = "Title length must be less than 255 characters")
	private String title;

	@Size(max = 500, message = "Description length must be less than 500 characters")
	private String description;

	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	@Min(value = 1, message = "Priority must be at least 1")
	@Max(value = 5, message = "Priority must be at most 5")
	private int priority;

	@FutureOrPresent(message = "Due date must not be in the past")
	private LocalDate dueDate;

	// Getters and Setters
}
