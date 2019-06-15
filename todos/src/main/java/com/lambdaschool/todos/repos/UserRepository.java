package com.lambdaschool.todos.repos;

import com.lambdaschool.todos.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}