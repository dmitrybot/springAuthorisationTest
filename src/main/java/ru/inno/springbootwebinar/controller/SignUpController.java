package ru.inno.springbootwebinar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.springbootwebinar.models.User;
import ru.inno.springbootwebinar.repositories.UsersRepository;

@Controller
public class SignUpController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp_page";
    }

    @PostMapping("/signUp")
    public String signUpUser(User user){
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "redirect:/signUp";
    }
}
