package eecs1012.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab1Activity extends AppCompatActivity
{
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        setTitle("EECS1022 W18 Lab3: RPS Game");
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

    public void round1pressed(View view){
        game = new Game(getTextViewValue(R.id.p1name), getTextViewValue(R.id.p2name));
        String p1choice = getSpinnerSelected(R.id.p1round1);
        String p2choice = getSpinnerSelected(R.id.p2round1);
        int result = game.match(p1choice, p2choice);
        switch (result){
            case 0: setTextViewValue(R.id.result, "round 1 finished: tie between "+ game.p1name + " and" + game.p2name); break;
            case 1: setTextViewValue(R.id.result, "round 1 finished: winner is "+game.p1name); break;
            case 2: setTextViewValue(R.id.result, "round 1 finished: winner is "+game.p2name); break;
        }
    }

    public void round2pressed(View view){
        String p1choice = getSpinnerSelected(R.id.p1round2);
        String p2choice = getSpinnerSelected(R.id.p2round2);
        game.match(p1choice, p2choice);
        if(Math.abs(game.p1winnings - game.p2winnings) > 1){
            game.isFinished = true;
        }

        if(game.isFinished){
            switch (game.overallWinner()){
                case 0: setTextViewValue(R.id.result, "round 2 finished: tie between "+ game.p1name + " and" + game.p2name + "\n(Game Over)"); break;
                case 1: setTextViewValue(R.id.result, "round 2 finished: winner is "+game.p1name + "\n(Game Over)"); break;
                case 2: setTextViewValue(R.id.result, "round 2 finished: winner is "+game.p2name + "\n(Game Over)"); break;
            }
        }
        else{
            switch (game.overallWinner()){
                case 0: setTextViewValue(R.id.result, "round 2 finished: tie between "+ game.p1name + " and" + game.p2name); break;
                case 1: setTextViewValue(R.id.result, "round 2 finished: winner is "+game.p1name); break;
                case 2: setTextViewValue(R.id.result, "round 2 finished: winner is "+game.p2name); break;
            }
        }
    }

    public void round3pressed(View view){
        if (game.isFinished){
            setTextViewValue(R.id.result, "Error: Game is already over");
            return;
        }

        String p1choice = getSpinnerSelected(R.id.p1round3);
        String p2choice = getSpinnerSelected(R.id.p2round3);
        game.match(p1choice, p2choice);

        switch (game.overallWinner()){
            case 0: setTextViewValue(R.id.result, "round 3 finished: tie between "+ game.p1name + " and" + game.p2name + "\n(Game Over)"); break;
            case 1: setTextViewValue(R.id.result, "round 3 finished: winner is "+game.p1name + "\n(Game Over)"); break;
            case 2: setTextViewValue(R.id.result, "round 3 finished: winner is "+game.p2name + "\n(Game Over)"); break;
        }
    }

    public void newGamePressed(View view){
        game = null;
        setTextViewValue(R.id.result, "New Game Started");
    }

}
