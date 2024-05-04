package com.example.demo.repo;

import com.example.demo.models.Airtickets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirticketsRepository extends CrudRepository<Airtickets, Long> {

}
