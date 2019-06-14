package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="todo")
public class Todo{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;


    @Column(name = "description", nullable = false, unique = true )
    private String description;

    @Column(name = "datestarted", nullable = false)

//    @CreatedDate

    protected String datestarted;


    @Column(name = "completed", nullable = false)
    private boolean completed = false;


    @OneToMany(mappedBy = "todo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("todo")
    private List<User> users = new ArrayList<>();

    public Todo(String description, String datestarted, boolean completed, List<User> users) {
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
        this.users = users;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(String datestarted) {
        this.datestarted = datestarted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
