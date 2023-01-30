package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.reposetry.UserReposetry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserReposetry userReposetry;

    public List<User> getUser(){
        return userReposetry.findAll();
    }

    public void addUser(int id, User user){
        userReposetry.save(user);
    }

    public boolean updateUser(int id, User user){
        User oldUser = userReposetry.getById(id);

        if(oldUser == null){
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        userReposetry.save(oldUser);
        return true;
    }

    public boolean deleteUser(int id){
        User oldUser = userReposetry.getById(id);
        if (oldUser == null){
            return false;
        }
        userReposetry.delete(oldUser);
        return true;

    }
}
