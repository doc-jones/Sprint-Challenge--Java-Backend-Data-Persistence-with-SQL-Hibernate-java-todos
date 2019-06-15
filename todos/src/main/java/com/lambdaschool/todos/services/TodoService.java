package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

import java.util.List;

public interface TodoService {
    List<Todos> findAllById(long id);

    Todos findTodosById(long id);

    Todos save(Todos todo);

    void delete(long id);

    Todos update(Todos todo, long id);
}

