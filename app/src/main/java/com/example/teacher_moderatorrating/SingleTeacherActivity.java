package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SingleTeacherActivity extends AppCompatActivity {

    private TextView school,name,desc;
    private ImageView imageView,filled1,empty1,filled2,empty2,filled3,empty3;
    private ScrollView scrollView;
    private RelativeLayout star1lay,star2lay,star3lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_teacher);

        filled1=findViewById(R.id.filled1);
        empty1=findViewById(R.id.empty1);
        filled2=findViewById(R.id.filled2);
        empty2=findViewById(R.id.empty2);
        filled3=findViewById(R.id.filled3);
        empty3=findViewById(R.id.empty3);

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

        empty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empty1.setVisibility(View.GONE);
                filled1.setVisibility(View.VISIBLE);

                empty2.setVisibility(View.VISIBLE);
                filled2.setVisibility(View.GONE);

                empty3.setVisibility(View.VISIBLE);
                filled3.setVisibility(View.GONE);
            }
        });
        empty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empty1.setVisibility(View.GONE);
                filled1.setVisibility(View.VISIBLE);

                empty2.setVisibility(View.GONE);
                filled2.setVisibility(View.VISIBLE);

                empty3.setVisibility(View.VISIBLE);
                filled3.setVisibility(View.GONE);
            }
        });
        empty3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empty1.setVisibility(View.GONE);
                filled1.setVisibility(View.VISIBLE);

                empty2.setVisibility(View.GONE);
                filled2.setVisibility(View.VISIBLE);

                empty3.setVisibility(View.GONE);
                filled3.setVisibility(View.VISIBLE);
            }
        });

        filled1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                empty1.setVisibility(View.VISIBLE);
                filled1.setVisibility(View.GONE);

                empty2.setVisibility(View.VISIBLE);
                filled2.setVisibility(View.GONE);

                empty3.setVisibility(View.VISIBLE);
                filled3.setVisibility(View.GONE);
            }
        });
        filled2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empty1.setVisibility(View.GONE);
                filled1.setVisibility(View.VISIBLE);

                empty2.setVisibility(View.VISIBLE);
                filled2.setVisibility(View.GONE);

                empty3.setVisibility(View.VISIBLE);
                filled3.setVisibility(View.GONE);
            }
        });
        filled3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empty1.setVisibility(View.GONE);
                filled1.setVisibility(View.VISIBLE);

                empty2.setVisibility(View.GONE);
                filled2.setVisibility(View.VISIBLE);

                empty3.setVisibility(View.VISIBLE);
                filled3.setVisibility(View.GONE);
            }
        });

        school.setText(s);
        name.setText(n);
        desc.setText(d);
        Glide.with(this)
                .asBitmap()
                .load(u)
                .into(imageView);
    }

}