package com.hojinj.terra;

import android.os.Bundle;
import android.app.Activity;
import android.os.content.Intent; 
import android.widget.Button; 

import com.google.firebase.FirebaseApp; 
import com.google.firebase.auth.FirebaseAuth;
import com.goolge.firebase.firestore.FirebaseFirestore; 

public class LoginActivity extends Activity {

    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent); 
        });
    }
}