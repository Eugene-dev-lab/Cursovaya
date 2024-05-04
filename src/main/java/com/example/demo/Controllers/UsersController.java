package com.example.demo.Controllers;

import com.example.demo.models.Clients;
import com.example.demo.models.Users;
import com.example.demo.repo.ClientsRepository;
import com.example.demo.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @GetMapping("/users")
    public String users(Model model) {
        Iterable<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users-main";
    }

    @GetMapping("/users/add")
    public String add(Model model) {
        return "users-add";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String login, @RequestParam String password, @RequestParam Long role_id, @RequestParam Long client_id) {
        Optional<Clients> client = clientsRepository.findById(client_id);
        if (client.isPresent()) {
            Users user = new Users(login, password, role_id, client_id);
            usersRepository.save(user);
        } else {
            return "redirect:/users/add";
        }
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/remove")
    public String deleteUser(@PathVariable("id") Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            Long clientId = user.get().getClient_id();
            usersRepository.deleteById(id);
            clientsRepository.deleteById(clientId);
        }
        return "redirect:/users";
    }
}