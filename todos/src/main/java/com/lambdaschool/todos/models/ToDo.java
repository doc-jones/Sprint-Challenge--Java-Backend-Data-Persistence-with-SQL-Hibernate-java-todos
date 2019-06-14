package com.lambdaschool.todos.models;

import javax.persistence.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "datestarted")
    private Date datestarted;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    private User user;

    public ToDo() {
    }

    public ToDo(String description,String datestarted, User user) {
        this.description = description;
        this.datestarted = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z", Locale.ENGLISH).parse(datestarted,new ParsePosition(0) );
        this.completed = false;
        this.user = user;
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

    public Date getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(Long datestarted) {

        this.datestarted = new Date(datestarted);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}