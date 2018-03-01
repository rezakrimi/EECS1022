package com.example.reza.eecs1022w18lab4bankapplication;

/**
 * Created by reza on 2/28/18.
 */

public class Bank {
    public Client client1, client2, client3;

    public Bank(String c1name, double c1balance, String c2name, double c2balance, String c3name, double c3balance) {
        client1 = new Client(c1name, c1balance);
        client2 = new Client(c2name, c2balance);
        client3 = new Client(c3name, c3balance);
    }

    public void transaction(String service, double amount, String from, String to){

        if (service.equals("deposit")){
            switch (to){
                case "client 1": client1.balance += amount; break;
                case "client 2": client2.balance += amount; break;
                case "client 3": client3.balance += amount; break;
                default: break;
            }
        }

        else if (service.equals("withdraw")){
            switch (from){
                case "client 1": client1.balance -= amount; break;
                case "client 2": client2.balance -= amount; break;
                case "client 3": client3.balance -= amount; break;
                default: break;
            }
        }

        else{
            if (from.equals("client 1")){
                switch (to){
                    case "client 1": break;
                    case "client 2": client1.balance -= amount; client2.balance += amount; break;
                    case "client 3": client1.balance -= amount; client3.balance += amount; break;
                }
            }
            else if (from.equals("client 2")){
                switch(to){
                    case "client 1": client1.balance += amount; client2.balance -= amount; break;
                    case "client 2": break;
                    case "client 3": client3.balance += amount; client2.balance -= amount; break;
                }
            }
            else if (from.equals("client 3")){
                switch (to){
                    case "client 1": client1.balance += amount; client3.balance -= amount; break;
                    case "client 2": client2.balance += amount; client3.balance -= amount; break;
                    case "client 3": break;
                }
            }
        }
    }
}
