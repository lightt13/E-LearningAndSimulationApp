package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class adminViewTest extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_view_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton users = findViewById(R.id.m1Btn);
        ImageButton exams = findViewById(R.id.m1Btn4);
        ImageButton logout = findViewById(R.id.m1Btn5);
        TextView header = findViewById(R.id.mainModulesHeader8);

        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));
        TextView firstQuestion = findViewById(R.id.quiz1Question);
        TextView firstQuestionFirstChoice = findViewById(R.id.quiz1Question1stChoice);
        TextView firstQuestionSecondChoice = findViewById(R.id.quiz1Question2ndChoice);
        TextView firstQuestionThirdChoice = findViewById(R.id.quiz1Question3rdChoice);
        TextView firstQuestionCorrect = findViewById(R.id.quiz1QuestionCorrect);

        TextView secondQuestion = findViewById(R.id.quiz2Question);
        TextView secondQuestionFirstChoice = findViewById(R.id.quiz2Question1stChoice);
        TextView secondQuestionSecondChoice = findViewById(R.id.quiz2Question2ndChoice);
        TextView secondQuestionThirdChoice = findViewById(R.id.quiz2Question3rdChoice);
        TextView secondQuestionCorrect = findViewById(R.id.quiz2QuestionCorrect);

        TextView thirdQuestion = findViewById(R.id.quiz3Question);
        TextView thirdQuestionFirstChoice = findViewById(R.id.quiz3Question1stChoice);
        TextView thirdQuestionSecondChoice = findViewById(R.id.quiz3Question2ndChoice);
        TextView thirdQuestionThirdChoice = findViewById(R.id.quiz3Question3rdChoice);
        TextView thirdQuestionCorrect = findViewById(R.id.quiz3QuestionCorrect);

        TextView fourthQuestion = findViewById(R.id.quiz4Question);
        TextView fourthQuestionFirstChoice = findViewById(R.id.quiz4Question1stChoice);
        TextView fourthQuestionSecondChoice = findViewById(R.id.quiz4Question2ndChoice);
        TextView fourthQuestionThirdChoice = findViewById(R.id.quiz4Question3rdChoice);
        TextView fourthQuestionCorrect = findViewById(R.id.quiz4QuestionCorrect);

        TextView fifthQuestion = findViewById(R.id.quiz5Question);
        TextView fifthQuestionFirstChoice = findViewById(R.id.quiz5Question1stChoice);
        TextView fifthQuestionSecondChoice = findViewById(R.id.quiz5Question2ndChoice);
        TextView fifthQuestionThirdChoice = findViewById(R.id.quiz5Question3rdChoice);
        TextView fifthQuestionCorrect = findViewById(R.id.quiz5QuestionCorrect);

        TextView sixthQuestion = findViewById(R.id.quiz6Question);
        TextView sixthQuestionFirstChoice = findViewById(R.id.quiz6Question1stChoice);
        TextView sixthQuestionSecondChoice = findViewById(R.id.quiz6Question2ndChoice);
        TextView sixthQuestionThirdChoice = findViewById(R.id.quiz6Question3rdChoice);
        TextView sixthQuestionCorrect = findViewById(R.id.quiz6QuestionCorrect);

        TextView seventhQuestion = findViewById(R.id.quiz7Question);
        TextView seventhQuestionFirstChoice = findViewById(R.id.quiz7Question1stChoice);
        TextView seventhQuestionSecondChoice = findViewById(R.id.quiz7Question2ndChoice);
        TextView seventhQuestionThirdChoice = findViewById(R.id.quiz7Question3rdChoice);
        TextView seventhQuestionCorrect = findViewById(R.id.quiz7QuestionCorrect);

        TextView eighthQuestion = findViewById(R.id.quiz8Question);
        TextView eighthQuestionFirstChoice = findViewById(R.id.quiz8Question1stChoice);
        TextView eighthQuestionSecondChoice = findViewById(R.id.quiz8Question2ndChoice);
        TextView eighthQuestionThirdChoice = findViewById(R.id.quiz8Question3rdChoice);
        TextView eighthQuestionCorrect = findViewById(R.id.quiz8QuestionCorrect);

        TextView ninthQuestion = findViewById(R.id.quiz9Question);
        TextView ninthQuestionFirstChoice = findViewById(R.id.quiz9Question1stChoice);
        TextView ninthQuestionSecondChoice = findViewById(R.id.quiz9Question2ndChoice);
        TextView ninthQuestionThirdChoice = findViewById(R.id.quiz9Question3rdChoice);
        TextView ninthQuestionCorrect = findViewById(R.id.quiz9QuestionCorrect);

        TextView tenthQuestion = findViewById(R.id.quiz10Question);
        TextView tenthQuestionFirstChoice = findViewById(R.id.quiz10Question1stChoice);
        TextView tenthQuestionSecondChoice = findViewById(R.id.quiz10Question2ndChoice);
        TextView tenthQuestionThirdChoice = findViewById(R.id.quiz10Question3rdChoice);
        TextView tenthQuestionCorrect = findViewById(R.id.quiz10QuestionCorrect);



        String quiz = getIntent().getExtras().getString("quiz");

        DocumentReference quiz1Data = db.collection("Quiz").document(quiz);

        DocumentReference choicesData = db.collection("Choices").document(quiz);



        quiz1Data.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                firstQuestion.setText("1." + documentSnapshot.getString("Question 1").toString());
                firstQuestionCorrect.setText("Correct:" + documentSnapshot.getString("Correct 1").toString());

                secondQuestion.setText("2. " + documentSnapshot.getString("Question 2"));
                secondQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 2"));

                thirdQuestion.setText("3. " + documentSnapshot.getString("Question 3"));
                thirdQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 3"));

                fourthQuestion.setText("4. " + documentSnapshot.getString("Question 4"));
                fourthQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 4"));

                fifthQuestion.setText("5. " + documentSnapshot.getString("Question 5"));
                fifthQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 5"));

                sixthQuestion.setText("6. " + documentSnapshot.getString("Question 6"));
                sixthQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 6"));

                seventhQuestion.setText("7. " + documentSnapshot.getString("Question 7"));
                seventhQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 7"));

                eighthQuestion.setText("8. " + documentSnapshot.getString("Question 8"));
                eighthQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 8"));

                ninthQuestion.setText("9. " + documentSnapshot.getString("Question 9"));
                ninthQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 9"));

                tenthQuestion.setText("10. " + documentSnapshot.getString("Question 10"));
                tenthQuestionCorrect.setText("Correct: " + documentSnapshot.getString("Correct 10"));






            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(adminViewTest.this, "Error", Toast.LENGTH_LONG).show();
            }
        });


        choicesData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                firstQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q1 1").toString());
                firstQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q1 2").toString());
                firstQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q1 3").toString());

                secondQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q2 1"));
                secondQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q2 2"));
                secondQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q2 3"));

                thirdQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q3 1"));
                thirdQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q3 2"));
                thirdQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q3 3"));

                fourthQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q4 1"));
                fourthQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q4 2"));
                fourthQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q4 3"));

                fifthQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q5 1"));
                fifthQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q5 2"));
                fifthQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q5 3"));

                sixthQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q6 1"));
                sixthQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q6 2"));
                sixthQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q6 3"));

                seventhQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q7 1"));
                seventhQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q7 2"));
                seventhQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q7 3"));

                eighthQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q8 1"));
                eighthQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q8 2"));
                eighthQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q8 3"));

                ninthQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q9 1"));
                ninthQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q9 2"));
                ninthQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q9 3"));

                tenthQuestionFirstChoice.setText("a. " + documentSnapshot.getString("Q10 1"));
                tenthQuestionSecondChoice.setText("b. " + documentSnapshot.getString("Q10 2"));
                tenthQuestionThirdChoice.setText("c. " + documentSnapshot.getString("Q10 3"));





            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(adminViewTest.this, "Error", Toast.LENGTH_LONG).show();
            }
        });







        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainAdmin.class);
                startActivity(intent);
            }
        });


    }
}