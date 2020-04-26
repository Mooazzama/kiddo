package com.example.kiddo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class kiddoLogin extends AppCompatActivity {

    EditText mFullName,mEmail,mPassword;
    Button mloginBtn;
    TextView mregisterBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiddo_login);


        mEmail      = findViewById(R.id.loginEmail);
        mPassword   = findViewById(R.id.loginPassword);
        mloginBtn= findViewById(R.id.loginBtn);
        mregisterBtn   = findViewById(R.id.textView1);


        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.loginProgressBar);



        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),home.class));
            finish();
        }


        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 8){
                    mPassword.setError("Password Must be > 8 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // login the user in firebase

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(kiddoLogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(kiddoLogin.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });



        mregisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),kiddoRegister.class));
            }
        });

    }
}