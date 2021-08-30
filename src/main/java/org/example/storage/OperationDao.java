package org.example.storage;

import org.example.entity.Operation;
import org.example.entity.User;

import java.util.List;

public interface OperationDao {
    void add(Operation operation);
    List<Operation> getAll(User user);
    void delete(long id);
}
