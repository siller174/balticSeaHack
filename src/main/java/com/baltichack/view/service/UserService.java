package com.baltichack.view.service;

import com.baltichack.view.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static final boolean flag = true;

    private List<User> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.add(new User((long)1, "Alex", "test@email.ri", "phone", "city", "data"));
        list.add(new User((long)2, "Vasya", "tes1t@email.ri", "phone", "city", "data"));
        list.add(new User((long)3, "Egor", "tes2t@email.ri", "phone", "city", "data"));
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
                if (id == user.getId())
                    list.remove(user);
            }
        }

//            UserRepo.deleteById(id);
    }



}
