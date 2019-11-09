package com.baltichack.view.service;

import com.baltichack.view.entity.User;
import com.baltichack.view.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static final boolean flag = true;

    public static List<User> list = new ArrayList<>();
    @Autowired
    private UserRepo UserRepo;

    public void addUser(User User) {
        if (flag)
            UserRepo.save(User);

    }

    public Iterable<User> listUser() {
        return UserRepo.findAll();
    }

    public void removeUser(Long id) {
        if(flag)
            UserRepo.deleteById(id);
    }
}
