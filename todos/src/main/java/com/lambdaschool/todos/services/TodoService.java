package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;

import java.util.ArrayList;

public interface TodoService
{
    ArrayList<Todo> findAll();

    Todo findTodosById(long id);

    Todo findTodosByName(String name);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);

    void deleteTodos(long todosid);

    void saveTodos(long todosid);
}

