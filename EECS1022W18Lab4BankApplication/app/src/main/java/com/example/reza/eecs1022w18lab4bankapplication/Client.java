package com.example.reza.eecs1022w18lab4bankapplication;

/**
 * Created by reza on 2/28/18.
 */

public class Client {
    public String name;
    public double balance;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
