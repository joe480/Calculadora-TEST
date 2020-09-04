package com.example.service;

import com.example.model.OperationModel;
import org.springframework.stereotype.Service;
import java.lang.Math;

@Service
public class CalculateSimple {

    public int add(OperationModel model){
        return model.getA() + model.getB();
    }

    public int subtract(OperationModel model){
        return model.getA() - model.getB();
    }

    public int multiply(OperationModel model){
        return model.getA() * model.getB();
    }

    public double divide(OperationModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }

    public int factorial(OperationModel model) {
        return factorial(model.getC());
    }

    private int factorial(int n){
        return n < 2 ? n : n * factorial(n-1);
    }

    public String fibonacci(OperationModel model){
        return fibonacci(model.getC());
    }

    private String fibonacci(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }

        String result = "1 ";
        int x = 0, y = 1, z = 1;
        for (int i = 1; i < n; i++) {
            z = x + y;
            result = result + z + " ";
            x = y;
            y = z;
        }
        return result;
    }

    public double sqrt(OperationModel model){
        return Math.sqrt(model.getC());
    }

    public int power(OperationModel model){
        return model.getC() * model.getC();
    }

    public OperationModel clearSimple(OperationModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }

    public OperationModel clearAdvanced(OperationModel model){
        model.setC(0);
        return model;
    }
}
