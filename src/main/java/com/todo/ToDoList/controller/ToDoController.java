package com.todo.ToDoList.controller;


import com.todo.ToDoList.model.ToDoItem;
import com.todo.ToDoList.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDoItem>> findAllToDos() {
        List<ToDoItem> toDoItems = toDoService.findAll();
        return ResponseEntity.ok().body(toDoItems);
    }

    @PostMapping("/todo")
    public ResponseEntity<ToDoItem> createToDo(@RequestBody ToDoItem toDoItem) {
        toDoService.save(toDoItem);
        return ResponseEntity.ok().body(toDoItem);
    }

    @PutMapping("/todo")
    public ResponseEntity<ToDoItem> updateToDo(@RequestBody ToDoItem toDoItem) {
        toDoService.save(toDoItem);
        return ResponseEntity.ok().body(toDoItem);
    }

    @GetMapping("todo/{id}")
    public ResponseEntity<ToDoItem> getToDoItem(@PathVariable int id) {
        ToDoItem toDoItem = toDoService.findById(id);
        return ResponseEntity.ok().body(toDoItem);
    }

    @DeleteMapping("todo/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable int id) {
        toDoService.deleteById(id);
        return ResponseEntity.ok().build();
    }



    @GetMapping("todo/user/{id}")
    public ResponseEntity<List<ToDoItem>> findAllToDosByUser(@PathVariable String id) {
        List<ToDoItem> toDoItems = toDoService.getTodos(id);
        return ResponseEntity.ok().body(toDoItems);
    }

}