package com.app.milkman.repository;


import com.app.milkman.model.db.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long> {
    List<AdminLogin> findByUserName(String userName);
    List<AdminLogin> findAdminLoginByUserName(String userName);

    List<AdminLogin> findAll();
}