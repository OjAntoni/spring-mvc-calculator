package org.example.service;

import org.example.entity.Operation;
import org.example.entity.User;
import org.example.storage.OperationDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
public class OperationService {
    private final OperationDao operationDao;

    public OperationService(@Qualifier("hibernateOperationDao") OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public Operation createInstance(double num1, double num2, String operationSign, User user){
        double result = calculateResult(num1, num2, operationSign);
        Operation operation = new Operation(0, num1, num2, operationSign, result, user);
        operation.setDate(new Date());
        return operation;
    }

    public double calculateResult(double num1, double num2, String operationSign){
        return switch(operationSign){
            case "sum" -> num1+num2;
            case "sub" -> num1-num2;
            case "mult" -> num1*num2;
            case "div" -> num1/num2;
            default -> Double.MIN_VALUE;
        };
    }

    public void save(Operation operation){
        operationDao.add(operation);
    }

    public List<Operation> getAll(User user){
        if (user==null){
            return List.of();
        }
        return operationDao.getAll(user);
    }

    public void delete(long id){
        operationDao.delete(id);
    }

}
