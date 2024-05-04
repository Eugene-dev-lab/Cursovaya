package com.example.demo.Controllers;



import ch.qos.logback.core.net.server.Client;
import com.example.demo.models.Clients;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repo.RolesRepository;
import com.example.demo.repo.UsersRepository;
import com.example.demo.repo.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;

@Controller
public class AuthorizationController {

    public static AuthUser AuthUser = new AuthUser();

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    private String errorMessage = "";
    private String errorMessage_reg = "";
    private String regMessage = "";

    private String login = "";
    private String first_name = "";
    private String phone = "";
    private String email = "";


    @GetMapping("/reg")
    public String reg(Model model) {

        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String login, @RequestParam String password, @RequestParam String address, @RequestParam String phone_number, @RequestParam String email, Model model) {

        try
        {
            Users users = usersRepository.findByLogin(login).orElseThrow();

        }
        catch (Exception e)
        {
            Clients client = new Clients(first_name,last_name,address,phone_number,email);
            clientsRepository.save(client);


            Iterable<Roles> roles = rolesRepository.findAll();
            Iterator<Roles> iterator2 = roles.iterator();
            Long role_id = null;
            while (iterator2.hasNext()) {
                Roles element = iterator2.next();
                if (element.getRole_name().equals("user") ){
                    role_id = element.getRole_id();
                }

            }

            Users users = new Users();
            users.setLogin(login);
            users.setPassword(password);
            users.setClient_id(client.getClient_id());
            users.setRole_id(role_id);


            usersRepository.save(users);

            regMessage = "You have been registred";

            return "redirect:/login";
        }


        return "redirect:/reg";


    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, Model model) {

        try
        {
            Users users = usersRepository.findByLogin(login).orElseThrow();
            System.out.println(users);
            if(users.getPassword().equals(password))
            {
                errorMessage = "";
                regMessage = "";

                Roles role = rolesRepository.findById(users.getRole_id()).orElseThrow();
                AuthUser.setAuthorized(true);
                AuthUser.setUser_id(users.getUser_id());

                if(role.getRole_name().equals("admin"))
                {
                    AuthUser.setRole_name("admin");
                    return "redirect:/";
                }
                else if(role.getRole_name().equals("user"))
                {
                    AuthUser.setRole_name("user");
                    return "redirect:/homeusers";
                }


            }
            else {
                errorMessage = "Incorrect password";
            }
        }
        catch (Exception e)
        {
            errorMessage = "Incorrect login";
        }


        return "redirect:/login";


    }

    @GetMapping("/login")
    public String login_(Model model) {

        AuthUser.setAuthorized(false);
        AuthUser.setRole_name("user");

        errorMessage_reg = "";
        this.login = "";
        this.first_name = "";
        this.phone = "";
        this.email = "";

        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("regMessage", regMessage);

        return "login";
    }
}