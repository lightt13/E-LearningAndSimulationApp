package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AdminTest extends AppCompatActivity {
    int counter = 0;
    FirebaseFirestore db;
    String question1;
    String question2;
    String question3;
    String answer;
    String ques;
    boolean isOnGoing = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView firstT = findViewById(R.id.firstT);
        TextView secondT = findViewById(R.id.secondT);
        TextView thirdT = findViewById(R.id.thirdT);
        TextView correctT = findViewById(R.id.correctT);
        TextView questionT = findViewById(R.id.questionT);
        TextView question= findViewById(R.id.quizQuestion);
        TextView first = findViewById(R.id.first);
        TextView second = findViewById(R.id.second);
        TextView third = findViewById(R.id.third);
        TextView correct= findViewById(R.id.correct);
        Button setB = findViewById(R.id.setB);
        TextView questionNumber = findViewById(R.id.questionNumber);

        ImageButton users = findViewById(R.id.testNavBtn);
        ImageButton exams = findViewById(R.id.testNavBtn4);
        ImageButton logout = findViewById(R.id.testNavBtn5);

        TextView header = findViewById(R.id.mainModulesHeader6);

        TextView quizNum = findViewById(R.id.quizNum);

        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));








        String quiz = getIntent().getExtras().getString("quiz");

        db = FirebaseFirestore.getInstance();

        quizNum.setText(quiz.toString());

        quizNum.setTextColor(Color.parseColor("white"));



        DocumentReference dataQuiz = db.collection("Quiz").document(quiz);
        DocumentReference dataChoices = db.collection("Choices").document(quiz);
        Map<String, Object> updates = new HashMap<>();




        /*
        firstT.setVisibility(View.INVISIBLE);
        secondT.setVisibility(View.INVISIBLE);
        thirdT.setVisibility(View.INVISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
        correct.setVisibility(View.INVISIBLE);
        correctT.setVisibility(View.INVISIBLE);

         */
        firstT.setText("first choice");
        secondT.setText("second choice");
        thirdT.setText("third choice");










        setB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(counter == 0){
                    ques = question.getText().toString();

                    updates.put("Question 1", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 1", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 1", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 1", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q1 1", question1);
                    updates.put("Q1 2", question2);
                    updates.put("Q1 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }
                else if(counter == 1){
                    ques = question.getText().toString();

                    updates.put("Question 2", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 2", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 2", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 2", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q2 1", question1);
                    updates.put("Q2 2", question2);
                    updates.put("Q2 3", question3);
                    dataChoices.update(updates);
                    updates.clear();


                }
                else if(counter == 2){
                    ques = question.getText().toString();

                    updates.put("Question 3", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 3", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 3", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 3", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q3 1", question1);
                    updates.put("Q3 2", question2);
                    updates.put("Q3 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }else if(counter == 3){
                    ques = question.getText().toString();

                    updates.put("Question 4", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 4", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 4", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 4", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q4 1", question1);
                    updates.put("Q4 2", question2);
                    updates.put("Q4 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }else if(counter == 4){
                    ques = question.getText().toString();

                    updates.put("Question 5", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 5", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 5", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 5", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q5 1", question1);
                    updates.put("Q5 2", question2);
                    updates.put("Q5 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }else if(counter == 5){
                    ques = question.getText().toString();

                    updates.put("Question 6", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 6", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 6", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 6", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q6 1", question1);
                    updates.put("Q6 2", question2);
                    updates.put("Q6 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }else if(counter == 6){
                    ques = question.getText().toString();

                    updates.put("Question 7", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 7", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 7", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 7", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q7 1", question1);
                    updates.put("Q7 2", question2);
                    updates.put("Q7 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }else if(counter == 7){
                    ques = question.getText().toString();

                    updates.put("Question 8", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 8", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 8", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 8", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q8 1", question1);
                    updates.put("Q8 2", question2);
                    updates.put("Q8 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }else if(counter == 8){
                    ques = question.getText().toString();

                    updates.put("Question 9", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 9", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 9", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 9", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q9 1", question1);
                    updates.put("Q9 2", question2);
                    updates.put("Q9 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }
                else if(counter == 9){
                    ques = question.getText().toString();

                    updates.put("Question 10", question.getText().toString());
                    if(Integer.parseInt(correct.getText().toString()) == 1){
                        answer = first.getText().toString();


                        updates.put("Correct 10", answer);

                    }
                    else if(Integer.parseInt(correct.getText().toString()) == 2){
                        answer = second.getText().toString();
                        updates.put("Correct 10", answer);


                    }
                    else{
                        answer = third.getText().toString();
                        updates.put("Correct 10", answer);


                    }
                    dataQuiz.update(updates);
                    updates.clear();
                    question1 = first.getText().toString();
                    question2 = second.getText().toString();
                    question3 = third.getText().toString();
                    updates.put("Q10 1", question1);
                    updates.put("Q10 2", question2);
                    updates.put("Q10 3", question3);
                    dataChoices.update(updates);
                    updates.clear();

                }









                counter++;

                question.setText("");
                first.setText("");
                second.setText("");
                third.setText("");
                correct.setText("");


                if(counter==0){
                    questionT.setText("Enter first question:");
                }
                else if(counter == 1){
                    questionT.setText("Enter second question:");
                    questionNumber.setText("2ND QUESTION");

                }
                else if(counter == 2){
                    questionT.setText("Enter third question:");
                    questionNumber.setText("3RD QUESTION");

                }else if(counter == 3){
                    questionT.setText("Enter fourth question:");
                    questionNumber.setText("4TH QUESTION");

                }else if(counter == 4){
                    questionT.setText("Enter fifth question:");
                    questionNumber.setText("5TH QUESTION");

                }else if(counter == 5){
                    questionT.setText("Enter sixth question:");
                    questionNumber.setText("6TH QUESTION");

                }else if(counter == 6){
                    questionT.setText("Enter seventh question:");
                    questionNumber.setText("7TH QUESTION");

                }else if(counter == 7){
                    questionT.setText("Enter eight question:");
                    questionNumber.setText("8TH QUESTION");

                }else if(counter == 8){
                    questionT.setText("Enter ninth question:");
                    questionNumber.setText("9TH QUESTION");

                }else if(counter == 9){
                    questionT.setText("Enter tenth question:");
                    questionNumber.setText("10TH QUESTION");

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