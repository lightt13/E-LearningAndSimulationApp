package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ModuleTest extends AppCompatActivity {
    FirebaseFirestore dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_module_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.moduleTestHeader), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        ImageButton btn1 = findViewById(R.id.testNavBtn1);
        ImageButton btn2 = findViewById(R.id.testNavBtn2);
        ImageButton btn3 = findViewById(R.id.testNavBtn3);
        TextView header = findViewById(R.id.testHeader);
        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));

        TextView exams = findViewById(R.id.testExams);
        TextView score1 = findViewById(R.id.Score1);
        TextView score2 = findViewById(R.id.Score2);
        TextView score3 = findViewById(R.id.Score3);
        TextView score4 = findViewById(R.id.Score4);
        TextView score5 = findViewById(R.id.Score5);


        Button testBtn1 = findViewById(R.id.testBtn1);
        Button testBtn2 = findViewById(R.id.testBtn2);
        Button testBtn3 = findViewById(R.id.testBtn3);
        Button testBtn4 = findViewById(R.id.testBtn4);
        Button testBtn5 = findViewById(R.id.testBtn5);
        Button mdlBtn = findViewById(R.id.mdlBtn);
        Button mdlBtn6 = findViewById(R.id.mdlBtn6);
        dBase = FirebaseFirestore.getInstance();


        btn3.setBackgroundColor(Color.parseColor("#00008B"));
        exams.setTextColor(Color.parseColor("#00008B"));
        testBtn1.setBackgroundColor(Color.parseColor("#6699CC"));
        testBtn2.setBackgroundColor(Color.parseColor("#D24D57"));
        testBtn3.setBackgroundColor(Color.parseColor("#D24D57"));
        testBtn4.setBackgroundColor(Color.parseColor("#D24D57"));
        testBtn5.setBackgroundColor(Color.parseColor("#D24D57"));

        mdlBtn.setBackgroundColor(Color.parseColor("#D24D57"));
        mdlBtn6.setBackgroundColor(Color.parseColor("#D24D57"));


        //Getting primary key
        String username = getIntent().getExtras().getString("username");




        //Getting data
        DocumentReference data = dBase.collection("user").document(username);






        data.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Long quiz1 = documentSnapshot.getLong("quiz1");
                Long quiz2 = documentSnapshot.getLong("quiz2");
                Long quiz3 = documentSnapshot.getLong("quiz3");
                Long quiz4 = documentSnapshot.getLong("quiz4");
                Long quiz5 = documentSnapshot.getLong("quiz5");



                if(quiz1>6){
                    testBtn2.setBackgroundColor(Color.parseColor("#6699CC"));
                    testBtn2.setText("Take");
                    mdlBtn6.setBackgroundColor(Color.parseColor("#6699CC"));


                }

                if(quiz2>6){
                    testBtn3.setBackgroundColor(Color.parseColor("#6699CC"));
                    testBtn3.setText("Take");

                }
                if(quiz3>6){
                    testBtn4.setBackgroundColor(Color.parseColor("#6699CC"));
                    testBtn4.setText("Take");
                    mdlBtn.setBackgroundColor(Color.parseColor("#6699CC"));


                }

                if(quiz4>6){
                    testBtn5.setBackgroundColor(Color.parseColor("#6699CC"));
                    testBtn5.setText("Take");

                }





                if(testBtn1.getText().toString().equals("Lock")){
                    score1.setText("Score:Not yet taken");
                }
                else{
                    score1.setText("Score:" + quiz1 + "/10");

                }

                if(testBtn2.getText().toString().equals("Lock")){
                    score2.setText("Score:Not yet taken");
                }
                else{
                    score2.setText("Score:" + quiz2 + "/10");

                }
                if(testBtn3.getText().toString().equals("Lock")){
                    score3.setText("Score:Not yet taken");
                }
                else{
                    score3.setText("Score:" + quiz3 + "/10");

                }

                if(testBtn4.getText().toString().equals("Lock")){
                    score4.setText("Score:Not yet taken");
                }
                else{
                    score4.setText("Score:" + quiz4 + "/10");

                }
                if(testBtn5.getText().toString().equals("Lock")){
                    score5.setText("Score:Not yet taken");
                }
                else{
                    score5.setText("Score:" + quiz5 + "/10");

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ModuleTest.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

            }
        });





        testBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Test1.class);
                intent.putExtra("username", username);
                intent.putExtra("quiz", "Quiz 1");
                startActivity(intent);



            }


        });

        testBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testBtn2.getText().toString().equals("Lock")){

                    Toast.makeText(ModuleTest.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Test1.class);
                    intent.putExtra("username", username);
                    intent.putExtra("quiz", "Quiz 2");
                    startActivity(intent);
                }

            }


        });

        mdlBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(testBtn2.getText().toString().equals("Lock")){


                    Toast.makeText(ModuleTest.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://shukuaki.github.io/UnityView/")));
                }

            }
        });

        testBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testBtn3.getText().toString().equals("Lock")){


                    Toast.makeText(ModuleTest.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Test1.class);
                    intent.putExtra("username", username);
                    intent.putExtra("quiz", "Quiz 3");
                    startActivity(intent);
                }

            }


        });



        testBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testBtn4.getText().toString().equals("Lock")){

                    Toast.makeText(ModuleTest.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Test1.class);
                    intent.putExtra("username", username);
                    intent.putExtra("quiz", "Quiz 4");
                    startActivity(intent);
                }

            }


        });

        mdlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(testBtn4.getText().toString().equals("Lock")){


                    Toast.makeText(ModuleTest.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://shukuaki.github.io/MyUnityWebGLGame")));
                }

            }
        });

        testBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testBtn5.getText().toString().equals("Lock")){

                    Toast.makeText(ModuleTest.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Test1.class);
                    intent.putExtra("username", username);
                    intent.putExtra("quiz", "Quiz 5");
                    startActivity(intent);
                }

            }


        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Modules.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}