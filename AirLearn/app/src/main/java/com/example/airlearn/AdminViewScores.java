package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminViewScores extends AppCompatActivity {
    FirebaseFirestore dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_view_scores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String username = getIntent().getExtras().getString("username");


        TextView header = findViewById(R.id.mainModulesHeader4);

        TextView name = findViewById(R.id.name);
        TextView quiz1 = findViewById(R.id.quiz1Score);
        TextView quiz2 = findViewById(R.id.quiz2Score);
        TextView quiz3 = findViewById(R.id.quiz3Score);
        TextView quiz4 = findViewById(R.id.quiz4Score);
        TextView quiz5 = findViewById(R.id.quiz5Score);

        ImageButton users = findViewById(R.id.m1Btn9);
        ImageButton exams = findViewById(R.id.m1Btn10);
        ImageButton logout = findViewById(R.id.m1Btn11);



        dBase = FirebaseFirestore.getInstance();


        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));




        DocumentReference db = dBase.collection("user").document(username);

        db.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                name.setText(documentSnapshot.getString("First Name") + " " + documentSnapshot.getString("Last Name"));
                if(documentSnapshot.getLong("quiz1") == 0){
                    quiz1.setText("Not yet taken");
                }
                else {
                    quiz1.setText(documentSnapshot.getLong("quiz1").toString());
                }
                if(documentSnapshot.getLong("quiz2") == 0){
                    quiz2.setText("Not yet taken");
                }
                else {
                    quiz2.setText(documentSnapshot.getLong("quiz2").toString());
                }
                if(documentSnapshot.getLong("quiz3") == 0){
                    quiz3.setText("Not yet taken");
                }
                else {
                    quiz3.setText(documentSnapshot.getLong("quiz3").toString());
                }
                if(documentSnapshot.getLong("quiz4") == 0){
                    quiz4.setText("Not yet taken");
                }
                else {
                    quiz4.setText(documentSnapshot.getLong("quiz4").toString());
                }
                if(documentSnapshot.getLong("quiz5") == 0){
                    quiz5.setText("Not yet taken");
                }
                else {
                    quiz5.setText(documentSnapshot.getLong("quiz5").toString());
                }


            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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

        exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminListTest.class);
                startActivity(intent);
            }
        });






    }
}