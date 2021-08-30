package org.example.storage.inMemoryDao;

import org.example.entity.Operation;
import org.example.entity.User;
import org.example.storage.OperationDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class InMemoryOperationDao implements OperationDao {

    private static final List<Operation> operations = new ArrayList<>();
    private static long idCount = 1;

    @Override
    public void add(Operation operation) {
        operation.setId(idCount);
        operations.add(operation);
        idCount++;
    }

    @Override
    public List<Operation> getAll(User user) {
        return operations.stream().filter(op -> op.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        int i;
        if(operations.stream().noneMatch(op -> op.getId()==id)){
            return;
        }
        for(i = 0; i < operations.size(); i++){
            if(operations.get(i).getId()==id){
                break;
            }
        }
        operations.remove(i);
    }
}
