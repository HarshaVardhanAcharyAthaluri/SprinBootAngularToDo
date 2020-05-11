package com.harsha.SpringBootAngularToDo.Exceptions;

public class TaskNotFoundException extends RuntimeException {

	public TaskNotFoundException(int id) {
		    super("Could not find Task " + id);
		  }
}
