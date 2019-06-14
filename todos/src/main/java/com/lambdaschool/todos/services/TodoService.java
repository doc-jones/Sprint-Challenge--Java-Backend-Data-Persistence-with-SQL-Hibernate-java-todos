package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.ToDo;
import com.lambdaschool.todos.repos.TodoRepository;

import java.util.ArrayList;

public interface TodoService
{
    ArrayList<ToDo> findAll();

    ToDo findTodosById(long id);

    ToDo findTodosByName(String name);

    void delete(long id);

    ToDo save(ToDo todo);

    ToDo update(ToDo todo, long id);

    void deleteTodos(long todosid);

    void saveTodos(long todosid);
}

