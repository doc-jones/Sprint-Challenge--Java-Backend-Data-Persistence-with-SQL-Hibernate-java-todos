package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repos.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todos;
    @Override
    public List<Todos> findAllById(long id) {
        System.out.println(id);

        List<Todos> todoList = new ArrayList<>();
        System.out.println(todos);
        todos.getAllById(id).iterator().forEachRemaining(todoList::add);
        return todoList;
    }

    @Override
    public Todos findTodosById(long id) {
        return todos.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Todos save(Todos todo) {
        return todos.save(todo);
    }

    @Override
    public void delete(long id) {
        if (todos.findById(id).isPresent()){
            todos.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }
    }
    @Override
    public Todos update(Todos todo, long id) {
        Todos currentTodo = todos.findById(id).orElseThrow(EntityNotFoundException::new);
        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getDescription() != null){
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.isCompleted()){
            currentTodo.setCompleted(true);
        }else{
            currentTodo.setCompleted(false);
        }
        todos.save(currentTodo);
        return currentTodo;
    }
}
