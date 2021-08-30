package org.example.controller;

import org.example.entity.Operation;
import org.example.entity.User;
import org.example.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    private OperationService operationService;

    public CalculatorController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public String getCalculate(){
        return "calc";
    }

    @PostMapping
    public String postCalculate(double num1, double num2, String operationSign, Model model, HttpSession session){
        double result = operationService.calculateResult(num1, num2, operationSign);
        model.addAttribute("result", result);
        Operation operation = operationService.createInstance(num1, num2, operationSign, ((User) session.getAttribute("user")));
        operationService.save(operation);
        return "calc";
    }

    @GetMapping("/history")
    public String getHistory(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Operation> all = operationService.getAll(user);
        model.addAttribute("operations", all);
        return "history";
    }

    @PostMapping("/history")
    public String postHistory(long id, Model model, HttpSession session){
        operationService.delete(id);
        model.addAttribute("operations", operationService.getAll(((User) session.getAttribute("user"))));
        return "history";
    }
}
