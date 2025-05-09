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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainAdmin extends AppCompatActivity {
    FirebaseFirestore dBase;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView header = findViewById(R.id.mainModulesHeader3);
        ListView list = findViewById(R.id.list);

        ImageButton users = findViewById(R.id.m1Btn6);
        ImageButton exams = findViewById(R.id.m1Btn7);
        ImageButton logout = findViewById(R.id.m1Btn8);

        TextView usersText = findViewById(R.id.adminModules2);

        users.setBackgroundColor(Color.parseColor("#00008B"));
        usersText.setTextColor(Color.parseColor("#00008B"));





        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));

        dBase = FirebaseFirestore.getInstance();




        dBase.collection("user").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<String> usernames = new ArrayList<>();
                    List<String> firstNames = new ArrayList<>();
                    List<String> lastNames = new ArrayList<>();
                    List<String> userDisplayList = new ArrayList<>();

                    for(DocumentSnapshot document : task.getResult()){
                        String username = document.getString("username").toString();
                        String firstName = document.getString("First Name").toString();
                        String lastName = document.getString("Last Name").toString();
                        usernames.add(username);
                        firstNames.add(firstName);
                        lastNames.add(lastName);

                        String displayName = "User:" + username + "- Name:" + firstName + " " + lastName;
                        userDisplayList.add(displayName);
                    }

                    String user;
                    if(usernames.isEmpty()){
                        Toast.makeText(MainAdmin.this,"No users found", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        ArrayAdapter<String> aAdapter = new ArrayAdapter<>(MainAdmin.this, android.R.layout.simple_list_item_1, userDisplayList);
                        list.setAdapter(aAdapter);

                        list.setOnItemClickListener((parent, view, position, id) -> {
                            String clickedUsername = usernames.get(position);
                            Intent intent = new Intent(getApplicationContext(), AdminViewScores.class);
                            intent.putExtra("username", clickedUsername);
                            startActivity(intent);


                        });





                    }


                    /*
                    for(int i=0; i<usernames.size(); i++) {
                        text.setText(usernames.get(i));


                    }

                     */

                }
            }
        });








        /*

        dBase.collection("user").document("asd").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.getString("username").toString();




            }
        });

         */





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




    }


}

