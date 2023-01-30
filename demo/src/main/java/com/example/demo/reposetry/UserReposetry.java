package com.example.demo.reposetry;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposetry extends JpaRepository<User, Integer> {
}
