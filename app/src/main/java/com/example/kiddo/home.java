package com.example.kiddo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

        final ImageButton button = findViewById(R.id.abcd);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, abc.class);
                startActivity(intent);
            }
        });
        final ImageButton button1 = findViewById(R.id.numbers);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, numbers.class);
                startActivity(intent);
            }

        });
        final ImageButton button2 = findViewById(R.id.speakButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, KidVoice.class);
                startActivity(intent);
            }

        });
    }
}
