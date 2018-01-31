package eecs1022.lab2;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab2Activity extends AppCompatActivity
{

    int[][] taxes = new int[3][3];



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        taxes[0] = new int[]{8350, 33950, 82250};
        taxes[1] = new int[]{16700, 67900, 137050};
        taxes[2] = new int[]{11950, 45500, 117450};
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Single", "Married", "Household"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
    }

    private String getInputOfTextField(int id){
        EditText editText = (EditText)findViewById(id);
        return editText.getText().toString();
    }

    private String getItemSelected(int id){
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String result = spinner.getSelectedItem().toString();
        return result;
    }

    private void setContentsOfTextView(int id, String newContents){
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    public void computeTax(View view){
        System.out.println("salam");
        String name = getInputOfTextField(R.id.NameInput);
        Double income = Double.parseDouble(getInputOfTextField(R.id.incomeInput));
        String status = getItemSelected(R.id.spinner);

        TaxPayer taxPayer = new TaxPayer(name, income, status);

        int statusFinder = 0;

        switch (status){
            case "Single": statusFinder = 0; break;
            case "Married": statusFinder = 1; break;
            case "Household": statusFinder = 2; break;
        }

        String temp = "";
        double finalTax = 0;

        temp += "Calculation is based on the scheme of " + taxPayer.getFs() + " Filing: \n";

        boolean isFinished = false;

        if(income >= taxes[statusFinder][0]){
            double part1 = taxes[statusFinder][0] * 0.10;
            temp += "Part I: $" + String.format("%.2f", part1) + '\n';
            finalTax += part1;
        }
        else{
            double part1 = income * 0.10;
            temp += "Part I: $" + String.format("%.2f", part1) + '\n';
            isFinished = true;
            finalTax += part1;
        }
        if(income >= taxes[statusFinder][1]){
            double part2 = (taxes[statusFinder][1] - taxes[statusFinder][0]) * 0.15;
            temp += "Part II: $" + String.format("%.2f", part2) + '\n';
            finalTax += part2;
        }
        else if (!isFinished){
            double part2 = (income - taxes[statusFinder][0]) * 0.15;
            temp += "Part II: $" + String.format("%.2f", part2) + '\n';
            isFinished = true;
            finalTax += part2;
        }
        if(income >= taxes[statusFinder][2]){
            double part3 = (taxes[statusFinder][2] - taxes[statusFinder][1]) * 0.25;
            temp += "Part III: $" + String.format("%.2f", part3) + '\n';
            finalTax += part3;
        }
        else if (!isFinished){
            double part3 = (income - taxes[statusFinder][1]) * 0.25;
            temp += "Part III: $" + String.format("%.2f", part3) + '\n';
            finalTax += part3;
            isFinished = true;
        }
        if(income >= taxes[statusFinder][2]){
            double part4 = (income - taxes[statusFinder][2]) * 0.30;
            temp += "Part IIII: $" + String.format("%.2f", part4) + '\n';
            finalTax += part4;
        }
        else if (!isFinished){
            double part4 = (income - taxes[statusFinder][2]) * 0.30;
            temp += "Part IIII: $" + String.format("%.2f", part4) + '\n';
            finalTax += part4;
        }

        String result = taxPayer.getName() + ", your tax due is $" + String.format("%.2f", finalTax) + '\n' + temp;

        setContentsOfTextView(R.id.results, result);
    }
}
