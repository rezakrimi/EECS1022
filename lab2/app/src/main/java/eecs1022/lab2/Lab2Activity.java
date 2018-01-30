package eecs1022.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Lab2Activity extends AppCompatActivity
{

    int[][] singleTax = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        singleTax[0] = new int[]{8350, 33950, 82250};
        singleTax[1] = new int[]{16700, 67900, 137050};
        singleTax[2] = new int[]{11950, 45500, 117450};
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Single", "Married", "Household"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
    }
}
