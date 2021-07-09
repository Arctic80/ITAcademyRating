package com.arcticsoft.rating.repositories;

import com.arcticsoft.rating.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByDni(String dni);
}
