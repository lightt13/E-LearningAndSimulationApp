package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class adminListTest extends AppCompatActivity {
    FirebaseFirestore dBase;
    String quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_list_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView header = findViewById(R.id.mainModulesHeader5);

        Button quiz1View = findViewById(R.id.quiz1View);
        Button quiz1Edit = findViewById(R.id.quiz1Edit);

        Button quiz2View = findViewById(R.id.quiz2View);
        Button quiz2Edit = findViewById(R.id.quiz2Edit);

        Button quiz3View = findViewById(R.id.quiz3View);
        Button quiz3Edit = findViewById(R.id.quiz3Edit);

        Button quiz4View = findViewById(R.id.quiz4View);
        Button quiz4Edit = findViewById(R.id.quiz4Edit);

        Button quiz5View = findViewById(R.id.quiz5View);
        Button quiz5Edit = findViewById(R.id.quiz5Edit);

        ImageButton users = findViewById(R.id.testNavBtn6);
        ImageButton exams = findViewById(R.id.testNavBtn7);
        ImageButton logout = findViewById(R.id.testNavBtn8);

        TextView examsText = findViewById(R.id.textView48);

        exams.setBackgroundColor(Color.parseColor("#00008B"));
        examsText.setTextColor(Color.parseColor("#00008B"));

        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));

        dBase = FirebaseFirestore.getInstance();


        quiz1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminViewTest.class);
                intent.putExtra("quiz", "Quiz 1");
                startActivity(intent);
            }
        });

        quiz1Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminTest.class);
                intent.putExtra("quiz", "Quiz 1");
                startActivity(intent);

            }
        });

        quiz2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminViewTest.class);
                intent.putExtra("quiz", "Quiz 2");
                startActivity(intent);
            }
        });

        quiz2Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminTest.class);
                intent.putExtra("quiz", "Quiz 2");
                startActivity(intent);

            }
        });

        quiz3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminViewTest.class);
                intent.putExtra("quiz", "Quiz 3");
                startActivity(intent);
            }
        });

        quiz3Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminTest.class);
                intent.putExtra("quiz", "Quiz 3");
                startActivity(intent);

            }
        });

        quiz4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminViewTest.class);
                intent.putExtra("quiz", "Quiz 4");
                startActivity(intent);
            }
        });

        quiz4Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminTest.class);
                intent.putExtra("quiz", "Quiz 4");
                startActivity(intent);

            }
        });

        quiz5View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminViewTest.class);
                intent.putExtra("quiz", "Quiz 5");
                startActivity(intent);
            }
        });

        quiz5Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminTest.class);
                intent.putExtra("quiz", "Quiz 5");
                startActivity(intent);

            }
        });

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainAdmin.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        /*

        dBase.collection("Quiz").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<String> quizzes = new ArrayList<>();

                    for(DocumentSnapshot document : task.getResult()){
                        String username = document.getId();
                        quizzes.add(username);
                    }

                    String user;
                    if(quizzes.isEmpty()){
                        Toast.makeText(adminListTest.this,"No users found", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        ArrayAdapter<String> aAdapter = new ArrayAdapter<>(adminListTest.this, android.R.layout.simple_list_item_1, quizzes);


                        list.setAdapter(aAdapter);

                        list.setOnItemClickListener((parent, view, position, id) -> {
                            String clickedQuiz = quizzes.get(position);
                            Intent intent = new Intent(getApplicationContext(), AdminTest.class);
                            intent.putExtra("quiz", clickedQuiz);
                            startActivity(intent);


                        });





                    }

                }
            }
        });

         */

    }
}