package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties({"quotes", "hibernateLazyInitializer"})
    private User user;

    public Todo()
    {
    }

    public Todo(String todo, User user)
    {
        this.todo = todo;
        this.user = user;
    }

    public long getToodsid()
    {
        return todoid;
    }

    public void setTodosid(long todosid)
    {
        this.todoid = todosid;
    }

    public String getTodos()
    {
        return todo;
    }

    public void setTodos(String todos)
    {
        this.todo = todos;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
