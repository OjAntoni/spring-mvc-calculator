package org.example.storage.inMemoryDao;

import org.example.entity.User;
import org.example.storage.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class InMemoryUserDao implements UserDao {

    private static final List<User> users = new ArrayList<>();
    private static long idCounter = 1;

    @Override
    public void add(User u) {
        users.add(u);
        u.setId(idCounter);
        idCounter++;
    }

    @Override
    public boolean exists(final String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    @Override
    public User getByUsername(String username) {
        for (User user1 : users) {
            if(user1.getUsername().equals(username)){
                return user1;
            }
        }
        return null;
    }

}
