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

public class AdminLoginSignupActivity extends AppCompatActivity {

    private TextView signup,login;
    private EditText username,password,adminusername,adminpassword;
    private RelativeLayout adminsignup,loginlayout;
    private Button saveadmin;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_signup);

        db= new DatabaseHelper(AdminLoginSignupActivity.this);

        adminpassword = findViewById(R.id.adminpassword);
        adminusername=findViewById(R.id.adminusername);

        password = findViewById(R.id.password);
        username=findViewById(R.id.username);

        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        adminsignup=findViewById(R.id.adminsignup);
        saveadmin=findViewById(R.id.saveadmin);
        loginlayout=findViewById(R.id.loginlayout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //todo : chck if admin is in db

                String usernm = username.getText().toString().trim();
                String pass=password.getText().toString().trim();

                Boolean res=  db.checkAdmin(usernm,pass);

                if(res==true){
                    Intent intent = new Intent(AdminLoginSignupActivity.this,AdminWorkActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(AdminLoginSignupActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }


            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginlayout.setVisibility(View.INVISIBLE);
                adminsignup.setVisibility(View.VISIBLE);
            }
        });

        saveadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //////////////////////////
                String username =adminusername.getText().toString().trim();
                String passw =adminpassword.getText().toString().trim();

                long value = db.addAdmin(username, passw);
                if(value>0){
                    Toast.makeText(AdminLoginSignupActivity.this,username+" Credentials Saved", Toast.LENGTH_SHORT).show();
                    loginlayout.setVisibility(View.VISIBLE);
                    adminsignup.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(AdminLoginSignupActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

                /////////////////
            }
        });

    }
}