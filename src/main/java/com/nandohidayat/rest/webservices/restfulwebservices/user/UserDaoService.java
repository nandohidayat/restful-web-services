package com.nandohidayat.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Nando", LocalDate.now().minusYears(25)));
        users.add(new User(2, "Laksita", LocalDate.now().minusYears(24)));
        users.add(new User(3, "Raissa", LocalDate.now().minusYears(26)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        return users.stream().filter(predicate).findFirst().get();
    }
}
