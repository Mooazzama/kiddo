package com.example.kiddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class learnC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_c);
        final MediaPlayer c = MediaPlayer.create(this, R.raw.c);

        final Button playC = (Button) this.findViewById(R.id.playsoundCBtn);

        playC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.start();
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
                if(x1< x2){
                    Intent i = new Intent(learnC.this, learnB.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

}
