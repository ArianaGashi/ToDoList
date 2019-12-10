package com.todo.ToDoList.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")

public class User {

    @Id
    private String id;

    @Size(min = 2, max = 30)
    private String name;

    public User() {
    }

    public User(String id, @Size(min = 2, max = 30) String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}