package com.app.milkman.repository;


import com.app.milkman.model.db.AdminLogin;
import com.app.milkman.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByName(String name);
    Optional<User> findById(Long aLong);

    List<User>  findAll();
}