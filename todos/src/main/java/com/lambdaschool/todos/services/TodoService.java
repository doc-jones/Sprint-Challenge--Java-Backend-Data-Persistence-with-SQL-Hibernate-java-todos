package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;

import java.util.List;

public interface TodoService
{
    List<Todo> findAll();

    Todo findTodoById(long id);

    List<Todo> findByUserName(String username);

    void delete(long id);

    Todo save(Todo quote);
}
