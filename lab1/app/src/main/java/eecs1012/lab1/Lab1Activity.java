package eecs1012.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab1Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
    }

    private void setContentsOfTextView(int id, String newContents){
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    private String getInputOfTextField(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    private String getItemSelected(int id){
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String result = spinner.getSelectedItem().toString();
        return result;
    }

    public void computeButton(View view){
        String textName = getInputOfTextField(R.id.inputName);
        String textWeight = getInputOfTextField(R.id.inputWeight);
        String textHeight = getInputOfTextField(R.id.inputHeight);

        double weight = Double.parseDouble(textWeight);
        double height = Double.parseDouble(textHeight);

        String weightUnit = getItemSelected(R.id.weightsSpinner);
        String heightUnit = getItemSelected(R.id.heightsSpinner);

        if("pounds".equals(weightUnit)){
            weight *= 0.453592;
        }

        switch(heightUnit){
            case "centimeters": height /= 100; break;
            case "inches": height *= 0.0254; break;
        }

        Person temp = new Person(textName, weight, height);
        String contents = textName + " has BMI " + temp.getBMI();
        setContentsOfTextView(R.id.labelAnswer, contents);
    }
}
