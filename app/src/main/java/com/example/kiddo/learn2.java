package com.example.kiddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class learn2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn2);
        final MediaPlayer two = MediaPlayer.create(this, R.raw.two);

        final Button play2 = (Button) this.findViewById(R.id.playsound2Btn);

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two.start();
            }
        });

    }
    float x1, x2, y1,y2;
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1> x2){
                    Intent i = new Intent(learn2.this, learn3.class);
                    startActivity(i);
                }
                 else if(x1< x2){
                    Intent i = new Intent(learn2.this, learn1.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
