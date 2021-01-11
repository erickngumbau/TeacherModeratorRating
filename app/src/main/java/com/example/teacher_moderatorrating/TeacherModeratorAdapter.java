package com.example.teacher_moderatorrating;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TeacherModeratorAdapter extends RecyclerView.Adapter<TeacherModeratorAdapter.ViewHolder>
{
    private ArrayList<Teacher> teachers =new ArrayList<>();
    private Context context;

    public TeacherModeratorAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_moderatorteacher,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(teachers.get(position).getName());
        holder.school.setText(teachers.get(position).getSchool());

        Glide.with(context)
                .asBitmap()
                .load(teachers.get(position).getUrl())
                .into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,SingleTeacherActivity.class);
                intent.putExtra("url",teachers.get(position).getUrl());
                intent.putExtra("school",teachers.get(position).getSchool());
                intent.putExtra("name",teachers.get(position).getName());
                intent.putExtra("description",teachers.get(position).getDescription());
                context.startActivity(intent);
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : REDIRECT TO THE ADMIN ADDING MORE TEACHERS
                //todo change visibilty id admin
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : DELETE THE RECORDS
                //todo change visibilty id admin

            }
        });
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private MaterialCardView cardView;
        private TextView school,name,delete,edit;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView =itemView.findViewById(R.id.card);
            school =itemView.findViewById(R.id.school);
            name=itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
            delete=itemView.findViewById(R.id.delete);
            edit=itemView.findViewById(R.id.edit);
        }
    }
}
