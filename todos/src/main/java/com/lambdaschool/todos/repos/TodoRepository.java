package com.lambdaschool.todos.repos;

import com.lambdaschool.todos.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<ToDo, Long>
{

}

