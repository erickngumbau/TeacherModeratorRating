package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddTeacherandModeratorActivity extends AppCompatActivity {

    private EditText name,sch,desc,imgurl;
    private TextView upload;
    private Button addteacherbtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacherand_moderator);

        db = new DatabaseHelper(AddTeacherandModeratorActivity.this);
        name=findViewById(R.id.name);
        sch=findViewById(R.id.school);
        desc=findViewById(R.id.description);
        imgurl=findViewById(R.id.imageurl);
        addteacherbtn=findViewById(R.id.addteacherbtn);


        addteacherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ////////////////////////////////////
                String username =name.getText().toString().trim();
                String school =sch.getText().toString().trim();
                String imageurl =imgurl.getText().toString().trim();
                String dsc =desc.getText().toString().trim();

                long value = db.addTeacher(username,school,dsc,imageurl);
                if(value>0){
                    Toast.makeText(AddTeacherandModeratorActivity.this, username+" Saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddTeacherandModeratorActivity.this,AdminWorkActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AddTeacherandModeratorActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
                }
                ////////////////////////////
            }
        });

    }
}