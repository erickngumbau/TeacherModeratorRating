package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SingleTeacherActivity extends AppCompatActivity {

    private TextView school,name,desc;
    private ImageView imageView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_teacher);

        school=findViewById(R.id.school);
        name=findViewById(R.id.name);
        desc=findViewById(R.id.description);
        imageView=findViewById(R.id.image);
        scrollView=findViewById(R.id.scroll);

        Intent intent = getIntent();
        String s=intent.getStringExtra("school");
        String n=intent.getStringExtra("name");
        String d=intent.getStringExtra("description");
        String u=intent.getStringExtra("url");

        school.setText(s);
        name.setText(n);
        desc.setText(d);
        Glide.with(this)
                .asBitmap()
                .load(u)
                .into(imageView);
    }
}