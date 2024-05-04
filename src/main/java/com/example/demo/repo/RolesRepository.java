package com.example.demo.repo;

import com.example.demo.models.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolesRepository extends CrudRepository<Roles, Long> {

}