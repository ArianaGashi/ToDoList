package com.todo.ToDoList.service;
import com.todo.ToDoList.model.ToDoItem;
import com.todo.ToDoList.model.User;
import com.todo.ToDoList.repository.ToDoRepository;
import com.todo.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;
    private UserRepository userRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }

    public List<ToDoItem> findAll() {
        return toDoRepository.findAll();
    }

    public void save(ToDoItem toDoItem) {
        toDoRepository.save(toDoItem);
    }

    public ToDoItem findById(int id) {
        Optional<ToDoItem> result = toDoRepository.findById(id);

        //     return result.orElse(null);
        ToDoItem toDoItem = null;

        if (result.isPresent()) {
            toDoItem = result.get();
        } else {
            throw new RuntimeException("ToDo not found");
        }
        return toDoItem;
    }

    public void deleteById(int id) {
        toDoRepository.deleteById(id);
    }


    public List<ToDoItem> getTodos(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return toDoRepository.findAllByUsers_Id(id);

        } else {
            throw new RuntimeException("User not present.");
        }
    }
}