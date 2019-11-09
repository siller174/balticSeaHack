package com.baltichack.view.service;

import com.baltichack.view.entity.User;
import com.baltichack.view.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo UserRepo;

    public void addUser(User User) {
//        UserRepo.save(User);
    }

    public Iterable<User> listUser() {
        return UserRepo.findAll();
    }

    public void removeUser(Long id) {
//        UserRepo.deleteById(id);
    }
}
