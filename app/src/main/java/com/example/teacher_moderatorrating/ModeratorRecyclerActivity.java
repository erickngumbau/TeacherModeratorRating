package com.example.teacher_moderatorrating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ModeratorRecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeacherModeratorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderator_recycler);

        recyclerView = findViewById(R.id.recycview);
        adapter = new TeacherModeratorAdapter(this);

        ArrayList<Teacher> teachers=new ArrayList<>();
        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Peter Tabichi","Computing and Informatics","Peter Mokaya Tabichi, " +
                "OFM is a Kenyan science teacher and Franciscan friar at Keriko Mixed Day " +
                "Secondary School in Pwani, Nakuru County. He is the winner of the 2019 Global Teacher Prize.",
                "https://upload.wikimedia.org/wikipedia/commons/9/9d/Peter_Tabichi_in_the_Oval_Office.jpg"));

        teachers.add(new Teacher("Hanan Al Hroub","Computing and Informatics","Hanan Al Hroub is" +
                " a Palestinian teacher who in 2016 was the second winner " +
                "of the Global Teacher Prize, which specialises in supporting children traumatised by violence.",
                "https://www.globalteacherprize.org/media/4274/hanan-headshot-178x178-178x178.jpg"));

        teachers.add(new Teacher("Andria Zafirakou","Computing and Informatics","Andria Zafirakou " +
                "is the 2018 Global Teacher Prize winner." +
                " She is an Arts and Textiles teacher at Alperton Community School in northwest London, England.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Andria-zafirakou-gtp-winner-2018.jpg/1200px-Andria-zafirakou-gtp-winner-2018.jpg"));

        teachers.add(new Teacher("Nancie Atwell","Computing and Informatics","Nancie Atwell is " +
                "an American educator who in 2015 became the first recipient of the Global Teacher Prize, a $1 million award " +
                "presented by the Varkey Foundation to" +
                " \"one innovative and caring teacher who has made an inspirational impact on their students and their" +
                " community",
                "https://www.globalteacherprize.org/media/1298/nanci_300x3001-178x178.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        teachers.add(new Teacher("Todd Whitaker","Computing and Informatics","Todd Whitaker is an" +
                " American educator, writer, motivational speaker, educational consultant, and professor." +
                " A leading presenter in the field of education, Dr. Whitaker has published over 30 books on staff " +
                "motivation, teacher leadership, technology, middle level practices, instructional improvement, and" +
                " principal effectiveness, including the national best-seller, What Great Teachers Do Differently.[1] " +
                "Before leaving in 2016, he was a professor of educational leadership at Indiana State University.",
                "https://upload.wikimedia.org/wikipedia/commons/9/99/Todd_Whitaker.jpg"));

        adapter.setTeachers(teachers);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}