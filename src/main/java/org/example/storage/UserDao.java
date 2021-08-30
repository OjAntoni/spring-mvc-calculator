package org.example.storage;

import org.example.entity.User;

public interface UserDao {
    void add(User u);
    boolean exists(String username);
    User getByUsername(String username);
}
