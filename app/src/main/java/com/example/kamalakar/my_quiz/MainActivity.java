package com.example.kamalakar.my_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button true_button,false_button;
    TextView question_text,score;
    ImageButton next,previous;
    int currentQuestionIndex=0;
    int points=0;
    Question[] question=new Question[]{
            new Question(R.string.bacteria,true),
            new Question(R.string.birds,true),
             new Question(R.string.bones,true),
             new Question(R.string.earthworm,false),
             new Question(R.string.napolean,false),
             new Question(R.string.smell,true),
            new Question(R.string.nails,false),
             new Question(R.string.space,true),
            new Question(R.string.goldfish,false),
            new Question(R.string.lightning,false),


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        true_button=findViewById(R.id.true_button);
        false_button=findViewById(R.id.false_button);
        question_text=findViewById(R.id.question_text);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        score=findViewById(R.id.score);
        true_button.setOnClickListener(this);
        false_button.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.true_button:
                update(true);
                break;
            case R.id.false_button:
                update(false);
                break;
            case R.id.next:
                currentQuestionIndex++;
                if(currentQuestionIndex>=question.length){
                    Toast.makeText(this, "End of questions!!!", Toast.LENGTH_SHORT).show();
                }
                else
                    question_text.setText(question[currentQuestionIndex].getAnswerid());
                score.setText(String.valueOf(points));

                break;
            case R.id.previous:
                currentQuestionIndex--;
                if(currentQuestionIndex<0) {
                    Toast.makeText(this, "This is the first question.Can't go beyond!", Toast.LENGTH_SHORT).show();
                    currentQuestionIndex++;
                }
                else{
                    question_text.setText(question[currentQuestionIndex].getAnswerid());

                }
                break;

        }
    }
    public void update(boolean useranswer){
        boolean answer=question[currentQuestionIndex].isTrue;
        if(answer==useranswer){
            Toast.makeText(this, "Hurray!!You are correct.Try next question", Toast.LENGTH_SHORT).show();
            points+=10;
        }
        else
            Toast.makeText(this, "Sorry!You are wrong.Keep going", Toast.LENGTH_SHORT).show();

    }
}
