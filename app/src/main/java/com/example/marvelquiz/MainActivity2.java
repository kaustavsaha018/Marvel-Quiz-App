package com.example.marvelquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatExtras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private String[] qNum = {"Question 1:","Question 2:","Question 3:"};
    private String[] questions = {"Is Captain America's shield made out of Vibranium?",
    "Scarlet Witch was born in Wakanda?","Can Spiderman lift Thor's Hammer?"};
    private boolean[] answers = {true,false,false};
    private int index = 0,score = 0;
    Button yes,no;
    TextView questionNum,questionText;
    ImageView changeImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        yes = findViewById(R.id.button2);
        no = findViewById(R.id.button1);
        questionNum = findViewById(R.id.textView2);
        questionText = findViewById(R.id.textView3);
        changeImage = findViewById(R.id.imageView2);
        questionNum.setText(qNum[index]);
        questionText.setText(questions[index]);

        changeImage.setImageResource(R.drawable.captain);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1){
                    if(answers[index]){
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1){
                        if(index==1)
                            changeImage.setImageResource(R.drawable.wanda);
                        if(index==2)
                            changeImage.setImageResource(R.drawable.thor);
                        questionNum.setText(qNum[index]);
                        questionText.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity2.this, "Your score is: "+score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity2.this, "Please touch the back button to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1){
                    if(!answers[index]){
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1){
                        if(index==1)
                            changeImage.setImageResource(R.drawable.wanda);
                        if(index==2)
                            changeImage.setImageResource(R.drawable.thor);
                        questionNum.setText(qNum[index]);
                        questionText.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity2.this, "Your score is: "+score, Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(MainActivity2.this, "Please touch the back button to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}