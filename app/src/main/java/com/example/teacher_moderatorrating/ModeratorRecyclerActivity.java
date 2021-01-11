package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ModeratorRecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeacherModeratorAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderator_recycler);

        recyclerView = findViewById(R.id.recycview);
//        adapter = new TeacherModeratorAdapter(this);
//
//        databaseHelper = new DatabaseHelper(ModeratorRecyclerActivity.this);
//        ArrayList<Teacher> allteachers = databaseHelper.getAllteachers();
//
//        adapter.setTeachers(allteachers);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new TeacherModeratorAdapter(this);

        databaseHelper = new DatabaseHelper(ModeratorRecyclerActivity.this);
        ArrayList<Teacher> allteachers = databaseHelper.getAllteachers();

        adapter.setTeachers(allteachers);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}