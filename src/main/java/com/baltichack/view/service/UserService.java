package com.baltichack.view.service;

import com.baltichack.view.entity.User;
import com.baltichack.view.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addUser(User user) {
        userRepo.save(user);

    }

    public Iterable<User> listUser() {
        return userRepo.findAll();
    }

    public void removeUser(Long id) {
            userRepo.deleteById(id);
    }
}
