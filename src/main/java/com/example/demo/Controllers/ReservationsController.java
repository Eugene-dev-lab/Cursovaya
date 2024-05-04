package com.example.demo.Controllers;

import com.example.demo.models.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationsController {
    @Autowired
    private com.example.demo.repo.ReservationsRepository ReservationsRepository;

    @GetMapping("/reservations")
    public String Reservations(Model model) {
        Iterable<Reservations> reservations = ReservationsRepository.findAll();
        model.addAttribute("reservations", reservations);
        return "reserv";
    }
}
