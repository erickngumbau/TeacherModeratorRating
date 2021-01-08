package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout loginlay,signuplay;
    private TextView login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        loginlay=findViewById(R.id.loginlayout);
        signuplay=findViewById(R.id.signuplayout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ModeratorRecyclerActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginlay.setVisibility(View.INVISIBLE);
                signuplay.setVisibility(View.VISIBLE);
            }
        });
    }
}