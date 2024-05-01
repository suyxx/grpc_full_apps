package org.example.user.repository;

import org.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
