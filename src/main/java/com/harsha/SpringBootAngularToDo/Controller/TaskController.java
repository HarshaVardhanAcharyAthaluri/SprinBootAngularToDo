package com.harsha.SpringBootAngularToDo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.harsha.SpringBootAngularToDo.Exceptions.TaskNotFoundException;
import com.harsha.SpringBootAngularToDo.model.Task;
import com.harsha.SpringBootAngularToDo.model.TaskRepository;

@Controller
public class TaskController {

	private final  TaskRepository taskRepo;
	
	public TaskController(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskName(@PathVariable int id) {
		
		return new ResponseEntity(taskRepo.findById(id),HttpStatus.OK);
	}

	@PostMapping("/task")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
		taskRepo.save(newTask);
	    return new ResponseEntity(taskRepo.findById(newTask.getTaskId()),HttpStatus.CREATED);
	  } 
	
	@GetMapping("/alltasks")
	public ResponseEntity<Task> getAllTasks(){
		
		return new ResponseEntity(taskRepo.findAll(), HttpStatus.OK);
		
	}

	
}
