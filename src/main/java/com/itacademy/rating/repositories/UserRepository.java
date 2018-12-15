package com.itacademy.rating.repositories;

import com.itacademy.rating.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Iterable<User> findByDni(String dni);
}
