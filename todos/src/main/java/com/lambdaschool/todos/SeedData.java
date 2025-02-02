package com.lambdaschool.todos;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.Role;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.models.UserRoles;
import com.lambdaschool.todos.repos.RoleRepository;
import com.lambdaschool.todos.repos.TodoRepository;
import com.lambdaschool.todos.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    TodoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, TodoRepository todorepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u1 = new User("barbar", "ILuvM4th!", users);
        User u2 = new User("admin", "password", admins);
//        User u3 = new User("Bob", "password", users);
//        User u4 = new User("Jane", "password", users);

        // the date and time string should get coverted to a datetime Java data type. This is done in the constructor!
        u1.getTodos().add(new Todos("Finish java-orders-swagger", "2019-01-13 04:04:04", u1));
        u1.getTodos().add(new Todos("Feed the turtles", "2019-03-01 04:04:04", u1));
        u1.getTodos().add(new Todos("Complete the sprint challenge", "2019-02-22 04:04:04", u1));

        u2.getTodos().add(new Todos("Walk the dogs", "2019-01-17 04:04:04", u2));
        u2.getTodos().add(new Todos("provide feedback to my instructor", "2019-02-13 04:04:04", u2));

        userrepos.save(u1);
        userrepos.save(u2);
//        userrepos.save(u3);
//        userrepos.save(u4);
    }
}