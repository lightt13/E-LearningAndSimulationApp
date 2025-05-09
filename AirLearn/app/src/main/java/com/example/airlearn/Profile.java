package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public class Profile extends AppCompatActivity {
    FirebaseFirestore dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView firstName = findViewById(R.id.firstNameText3);
        TextView lastName = findViewById(R.id.lastNameText);
        TextView birthDate = findViewById(R.id.birthDateText);
        TextView usernameText = findViewById(R.id.usernameText);
        TextView logoutText = findViewById(R.id.logoutText);
        TextView quiz1 = findViewById(R.id.quiz1Score2);
        TextView quiz2 = findViewById(R.id.quiz2Score2);
        TextView quiz3 = findViewById(R.id.quiz3Score2);
        TextView quiz4 = findViewById(R.id.quiz4Score2);
        TextView quiz5 = findViewById(R.id.quiz5Score2);

        ImageButton modules = findViewById(R.id.m1Btn12);
        ImageButton profile = findViewById(R.id.m1Btn13);
        ImageButton exam = findViewById(R.id.m1Btn14);

        //Button logout = findViewById(R.id.profileLogout);

        TextView profileText = findViewById(R.id.m2Modules5);

        TextView header = findViewById(R.id.mainModulesHeader7);

        profile.setBackgroundColor(Color.parseColor("#00008B"));
        profileText.setTextColor(Color.parseColor("#00008B"));

        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));

        String username = getIntent().getExtras().getString("username");

        dBase = FirebaseFirestore.getInstance();

        DocumentReference db = dBase.collection("user").document(username);



        db.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                firstName.setText(documentSnapshot.getString("First Name"));
                lastName.setText(documentSnapshot.getString("Last Name"));
                birthDate.setText(documentSnapshot.getString("Birth Date"));
                usernameText.setText(documentSnapshot.getString("username"));
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

        modules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Modules.class);
                intent.putExtra("username", username);
                startActivity(intent);

            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ModuleTest.class);
                intent.putExtra("username", username);
                startActivity(intent);

            }
        });

        /*
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

         */

        logoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });





    }
}