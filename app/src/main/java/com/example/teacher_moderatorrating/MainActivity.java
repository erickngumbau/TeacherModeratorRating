package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Student studentmodel;

    private RelativeLayout loginlay,signuplay,adminlayout;
    private TextView login,signup;
    private Button student,adminsignuplogin;
    private DatabaseHelper db;
    private EditText username,password,signupusername,signuppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        db = new DatabaseHelper(MainActivity.this);

        adminsignuplogin = findViewById(R.id.adminsignuplogin);


        loginlay=findViewById(R.id.loginlayout);
        signuplay=findViewById(R.id.signuplayout);
        student=findViewById(R.id.btnsave);

        username =findViewById(R.id.username);
        password=findViewById(R.id.password);

        signupusername =findViewById(R.id.username1);
        signuppassword=findViewById(R.id.password1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernm = username.getText().toString().trim();
                String pass=password.getText().toString().trim();

                Boolean res=  db.checkStudent(usernm,pass);

                if(res==true){
                    Intent intent = new Intent(MainActivity.this,ModeratorRecyclerActivity.class);
                    intent.putExtra("username",usernm);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }


                //todo if admin
//                Intent intent = new Intent(MainActivity.this,AdminWorkActivity.class);
//                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginlay.setVisibility(View.INVISIBLE);
                signuplay.setVisibility(View.VISIBLE);


                student.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        /////////////
                        String username =signupusername.getText().toString().trim();
                        String passw =signuppassword.getText().toString().trim();

                        long value = db.addStudent(username, passw);
                        if(value>0){
                            Toast.makeText(MainActivity.this, username+" Credentials Saved", Toast.LENGTH_SHORT).show();
                            loginlay.setVisibility(View.VISIBLE);
                            signuplay.setVisibility(View.INVISIBLE);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                        }

                        ////////

                    }
                });

            }
        });

        //todo : work on signup if user == admin/
        adminsignuplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AdminLoginSignupActivity.class);
                startActivity(intent);
            }
        });
    }
}