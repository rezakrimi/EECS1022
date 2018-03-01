package com.example.reza.eecs1022w18lab4bankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Bank bank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getTextViewValue(int id){
        TextView textView = (TextView)findViewById(id);
        return textView.getText().toString();
    }

    public void setTextViewValue(int id, String input){
        TextView textView = (TextView)findViewById(id);
        textView.setText(input);
    }

    public String getSpinnerSelected(int id){
        Spinner spinner = (Spinner) findViewById(id);
        return spinner.getSelectedItem().toString();
    }

    public void updateResult(){
        String result = "";
        result += "Client " + bank.client1.getName() + " has balance $" + String.format("%.2f", bank.client1.getBalance()) + "\n";
        result += "Client " + bank.client2.getName() + " has balance $" + String.format("%.2f", bank.client2.getBalance()) + "\n";
        result += "Client " + bank.client3.getName() + " has balance $" + String.format("%.2f", bank.client3.getBalance());
        setTextViewValue(R.id.result, result);
    }

    public void createAccounts(View view){
        String c1name = getTextViewValue(R.id.clinet1Name), c2name = getTextViewValue(R.id.client2Name), c3name = getTextViewValue(R.id.client3Name);
        double c1balance, c2balance, c3balance;
        c1balance = Double.parseDouble(getTextViewValue(R.id.client1Balance));
        c2balance = Double.parseDouble(getTextViewValue(R.id.clinet2Balance));
        c3balance = Double.parseDouble(getTextViewValue(R.id.client3Balance));

        bank = new Bank(c1name, c1balance, c2name, c2balance, c3name, c3balance);

        updateResult();
    }

    public void completeTransaction(View view){
        bank.transaction(getSpinnerSelected(R.id.services), Double.parseDouble(getTextViewValue(R.id.amount)), getSpinnerSelected(R.id.from), getSpinnerSelected(R.id.to));

        updateResult();
    }
}
