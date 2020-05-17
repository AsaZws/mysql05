package com.asa.demo05.dao;

import com.asa.demo05.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */

public interface UserDao extends JpaRepository<User, Integer> {



}
