package com.example.demo.repo;


import com.example.demo.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users,Long> {
    Optional<Users> findByLogin(String login);
}
