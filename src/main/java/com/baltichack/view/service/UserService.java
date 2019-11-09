package com.baltichack.view.service;

import com.baltichack.view.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static final boolean flag = true;

    private List<User> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.add(new User(1, "Alex", "/api/event/1"));
        list.add(new User(2, "Alex", "/api/event/2"));
        list.add(new User(3, "Alex", "/api/event/3"));
    }


//    @Autowired
//    private UserRepo UserRepo;

    public void addUser(User User) {
        if (flag) {
            list.add(User);
        }
//            UserRepo.save(User);

    }

    public Iterable<User> listUser() {
        return list;
//        return UserRepo.findAll();
    }

    public void removeUser(Long id) {
        if(flag) {
            for (User user : list) {
                if (id == (long) user.getId())
                    list.remove(user);
            }
        }

//            UserRepo.deleteById(id);
    }



}
