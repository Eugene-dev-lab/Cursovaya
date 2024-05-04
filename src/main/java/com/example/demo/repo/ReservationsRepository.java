package com.example.demo.repo;

import com.example.demo.models.Reservations;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsRepository extends CrudRepository<Reservations, Long> {
}
