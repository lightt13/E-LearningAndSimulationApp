package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
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

public class Modules extends AppCompatActivity {
    FirebaseFirestore dBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modules);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.moduleTestHeader), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btn1 = findViewById(R.id.btn1);
        ImageButton btn2 = findViewById(R.id.btn2);
        ImageButton btn3 = findViewById(R.id.btn3);
        TextView header = findViewById(R.id.mainModulesHeader);
        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));

        TextView modules = findViewById(R.id.modules);

        Button mdlBtn1 = findViewById(R.id.mdlBtn1);
        Button mdlBtn2 = findViewById(R.id.mdlBtn2);
        Button mdlBtn3 = findViewById(R.id.mdlBtn3);
        Button mdlBtn4 = findViewById(R.id.mdlBtn4);
        Button mdlBtn5 = findViewById(R.id.mdlBtn5);
        dBase = FirebaseFirestore.getInstance();


        btn1.setBackgroundColor(Color.parseColor("#00008B"));
        modules.setTextColor(Color.parseColor("#00008B"));
        mdlBtn1.setBackgroundColor(Color.parseColor("#6699CC"));
        mdlBtn2.setBackgroundColor(Color.parseColor("#D24D57"));
        mdlBtn3.setBackgroundColor(Color.parseColor("#D24D57"));
        mdlBtn4.setBackgroundColor(Color.parseColor("#D24D57"));
        mdlBtn5.setBackgroundColor(Color.parseColor("#D24D57"));


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
                    mdlBtn2.setBackgroundColor(Color.parseColor("#6699CC"));
                    mdlBtn2.setText("Read");

                }

                if(quiz2>6){
                    mdlBtn3.setBackgroundColor(Color.parseColor("#6699CC"));
                    mdlBtn3.setText("Read");

                }
                if(quiz3>6){
                    mdlBtn4.setBackgroundColor(Color.parseColor("#6699CC"));
                    mdlBtn4.setText("Read");

                }

                if(quiz4>6){
                    mdlBtn5.setBackgroundColor(Color.parseColor("#6699CC"));
                    mdlBtn5.setText("Read");

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Modules.this, "Fail to retrieve data", Toast.LENGTH_LONG).show();

            }
        });



        mdlBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Module1.class);
                intent.putExtra("username", username);
                startActivity(intent);



            }


        });

        mdlBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mdlBtn2.getText().toString().equals("Lock")){

                    Toast.makeText(Modules.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Module2.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }

            }


        });

        mdlBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mdlBtn3.getText().toString().equals("Lock")){

                    Toast.makeText(Modules.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Module3.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }

            }


        });

        mdlBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mdlBtn4.getText().toString().equals("Lock")){

                    Toast.makeText(Modules.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Module4.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }

            }


        });

        mdlBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mdlBtn5.getText().toString().equals("Lock")){

                    Toast.makeText(Modules.this, "Pass the exam of the previous module first", Toast.LENGTH_LONG).show();

                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Module5.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }

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


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModuleTest.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });


    }
}