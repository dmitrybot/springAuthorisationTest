package ru.inno.springbootwebinar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inno.springbootwebinar.models.User;
import ru.inno.springbootwebinar.repositories.UsersRepository;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }
}
