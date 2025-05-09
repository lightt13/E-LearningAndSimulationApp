package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

import java.util.HashMap;
import java.util.Map;

public class Test1 extends AppCompatActivity {
    Integer counting = 1;
    Integer points = 0;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String questionHolder;
    String qChoice1;
    String qChoice2;
    String qChoice3;
    String correct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.moduleTestHeader), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        boolean isOnGoing = true;
        String username = getIntent().getExtras().getString("username");
        String quiz = getIntent().getExtras().getString("quiz");


        ImageButton btn = findViewById(R.id.btn);
        ImageButton btn4 = findViewById(R.id.btn4);
        ImageButton btn5 = findViewById(R.id.btn5);
        TextView exams = findViewById(R.id.exam);
        TextView header = findViewById(R.id.testOneHeader);
        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));


        TextView question = (TextView) findViewById(R.id.question);
        TextView score = (TextView) findViewById(R.id.score);
        Button sButton = (Button) findViewById(R.id.sButton);
        RadioButton choice1 = findViewById(R.id.rdBtn1);
        RadioButton choice2 = findViewById(R.id.rdBtn2);
        RadioButton choice3 = findViewById(R.id.rdBtn3);
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);



        Button back = findViewById(R.id.backB);

        GradientDrawable draw = new GradientDrawable();

        draw.setShape(GradientDrawable.RECTANGLE);

        back.setBackground(draw);

        back.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);

        DocumentReference userData = db.collection("user").document(username);

        DocumentReference quiz1Data = db.collection("Quiz").document(quiz);

        DocumentReference choicesData = db.collection("Choices").document(quiz);



        Map<String, Object> updates = new HashMap<>();









        String[] Questions = {"What's the name of the actor that played Iron Man in Avengers?",
                "What's the name of Spongebob friend that is a starfish"};




        quiz1Data.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                questionHolder = documentSnapshot.getString("Question " + counting.toString());
                correct = documentSnapshot.getString("Correct " + counting.toString());
                question.setText(counting.toString() + ". " + questionHolder);





            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Test1.this, "Error", Toast.LENGTH_LONG).show();
            }
        });



        choicesData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                qChoice1 = documentSnapshot.getString("Q" + counting.toString() + " 1");
                qChoice2 = documentSnapshot.getString("Q" + counting.toString() + " 2");
                qChoice3 = documentSnapshot.getString("Q" + counting.toString() + " 3");
                choice1.setText(qChoice1);
                choice2.setText(qChoice2);
                choice3.setText(qChoice3);





            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Test1.this, "Error", Toast.LENGTH_LONG).show();
            }
        });












        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!choice1.isChecked() && !choice2.isChecked() && !choice3.isChecked()){
                    Toast.makeText(Test1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(choice1.isChecked()) {
                    choice1.setChecked(false);
                }
                if(choice2.isChecked()) {
                    choice2.setChecked(false);
                }
                if(choice3.isChecked()) {
                    choice3.setChecked(false);
                }


                int selectedId = radioGroup1.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(Test1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return; // Do not proceed if no answer is selected
                }

                RadioButton selected = findViewById(radioGroup1.getCheckedRadioButtonId());
                if (selected != null) {
                    String selectedText = selected.getText().toString();
                    if (selectedText.equals(correct)) {
                        points++;
                    }
                }






                counting++;


                    quiz1Data.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            questionHolder = documentSnapshot.getString("Question " + counting.toString());
                            correct = documentSnapshot.getString("Correct " + counting.toString());









                            question.setText(counting.toString() + ". " + questionHolder);


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Test1.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    });

                    choicesData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            qChoice1 = documentSnapshot.getString("Q" + counting.toString() + " 1");
                            qChoice2 = documentSnapshot.getString("Q" + counting.toString() + " 2");
                            qChoice3 = documentSnapshot.getString("Q" + counting.toString() + " 3");
                            choice1.setText(qChoice1);
                            choice2.setText(qChoice2);
                            choice3.setText(qChoice3);


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Test1.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    });







                /*
                if(counting == 0){
                    if(choice1.isChecked()){
                        points++;

                    }


                }else if(counting == 1){
                    if(choice1.isChecked()){
                        points++;

                    }


                }
                else if(counting == 2){
                    if(choice2.isChecked()){
                        points++;

                    }
                    updates.put("quiz1",points);
                    userData.update(updates);


                }





                counting++;

                if(counting == 1){
                    question.setText(Questions[counting-1]);
                    choice1.setText("Robert Downey Jr.");
                    choice2.setText("Chris Evans");
                    choice3.setText("Chris Hemsworth");
                    /*if(choice1.isChecked()){
                        points++;
                    }*/
                /*
                }
                if(counting == 2){
                    question.setText(Questions[counting-1]);
                    choice1.setText("Squidward");
                    choice2.setText("Patrick");
                    choice3.setText("Sandy");

                    /*if(choice2.isChecked()){
                        points++;
                    }*/

                /*
                }


                 */




























                if(counting==11){
                    back.setVisibility(View.VISIBLE);
                    score.setVisibility(View.VISIBLE);
                    sButton.setVisibility(View.INVISIBLE);
                    choice1.setVisibility(View.INVISIBLE);
                    choice2.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.INVISIBLE);
                    question.setVisibility(View.INVISIBLE);

                    if(quiz.equals("Quiz 1")) {


                        score.setText("The score: " + points + "/ 10");
                        userData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                Long quiz1 = documentSnapshot.getLong("quiz1");
                                int quizPoints = points;
                                if (!quiz1.equals(0) && quizPoints > 6) {
                                    updates.put("quiz1", points);
                                    userData.update(updates);
                                } else if (quiz1.equals(0)) {
                                    updates.put("quiz1", points);
                                    userData.update(updates);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Test1.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

                            }
                        });
                    }

                    if(quiz.equals("Quiz 2")) {



                        score.setText("The score: " + points + "/ 10");
                        userData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                Long quiz2 = documentSnapshot.getLong("quiz2");
                                int quizPoints = points;
                                if(!quiz2.equals(0) && quizPoints > 6) {
                                    updates.put("quiz2", points);
                                    userData.update(updates);
                                }else if(quiz2.equals(0)){
                                    updates.put("quiz2", points);
                                    userData.update(updates);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Test1.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

                            }
                        });




                    }

                    if(quiz.equals("Quiz 3")) {

                        score.setText("The score: " + points + "/ 10");
                        userData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                Long quiz3 = documentSnapshot.getLong("quiz3");
                                int quizPoints = points;
                                if(!quiz3.equals(0) && quizPoints > 6) {
                                    updates.put("quiz3", points);
                                    userData.update(updates);
                                }else if(quiz3.equals(0)){
                                    updates.put("quiz3", points);
                                    userData.update(updates);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Test1.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

                            }
                        });
                    }



                    if(quiz.equals("Quiz 4")) {
                        score.setText("The score: " + points + "/ 10");
                        userData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                Long quiz4 = documentSnapshot.getLong("quiz4");
                                int quizPoints = points;
                                if(!quiz4.equals(0) && quizPoints > 6) {
                                    updates.put("quiz4", points);
                                    userData.update(updates);
                                }else if(quiz4.equals(0)){
                                    updates.put("quiz4", points);
                                    userData.update(updates);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Test1.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

                            }
                        });



                        /*
                        score.setText("The score: " + points + "/ 10");
                        updates.put("quiz4", points);
                        userData.update(updates);

                         */
                    }

                    if(quiz.equals("Quiz 5")) {

                        score.setText("The score: " + points + "/ 10");
                        userData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                Long quiz5 = documentSnapshot.getLong("quiz5");
                                int quizPoints = points;
                                if(!quiz5.equals(0) && quizPoints > 6) {
                                    updates.put("quiz5", points);
                                    userData.update(updates);
                                }else if(quiz5.equals(0)){
                                    updates.put("quiz5", points);
                                    userData.update(updates);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Test1.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

                            }
                        });
                    }



                }
            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModuleTest.class);
                intent.putExtra("username", username);
                startActivity(intent);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Modules.class);
                intent.putExtra("username", username);
                startActivity(intent);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModuleTest.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });


    }
}