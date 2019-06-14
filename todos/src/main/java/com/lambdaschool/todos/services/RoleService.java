package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    @Transactional
    Role save(Role role);
}

