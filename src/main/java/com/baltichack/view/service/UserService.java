package com.baltichack.view.service;

import com.baltichack.view.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    public static final boolean flag = true;
    @SuppressWarnings("unchecked")
    private Map<Long, User> map = new ConcurrentHashMap();

    @PostConstruct
    public void init() {
        map.put(1L, new User((long)1, "Alex", "test@email.ri", "phone", "city", "data"));
        map.put(2L, new User((long)2, "Vasya", "tes1t@email.ri", "phone", "city", "data"));
        map.put(3L, new User((long)3, "Egor", "tes2t@email.ri", "phone", "city", "data"));
    }


//    @Autowired
//    private UserRepo UserRepo;

    public void addUser(Long Id, User User) {
        if (flag) {
            if (!map.containsKey(Id)) {
                map.put(Id, User);
            }
        }
//            UserRepo.save(User);

    }

    public Iterable<User> listUser() {
        return map.values();
//        return UserRepo.findAll();
    }

    public void removeUser(Long id) {
        if(flag) {
                map.remove(id);
        }

//            UserRepo.deleteById(id);
    }



}
