package com.example.kiddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class learn1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);
        final MediaPlayer one = MediaPlayer.create(this, R.raw.one);

        final Button play1 = (Button) this.findViewById(R.id.playsound1Btn);

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.start();
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
                    Intent i = new Intent(learn1.this, learn2.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
