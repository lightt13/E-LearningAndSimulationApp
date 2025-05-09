    package com.example.airlearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

    public class MainActivity extends AppCompatActivity {
        FirebaseFirestore dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.moduleTestHeader), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Button register = findViewById(R.id.loginRegister);



        TextView registerText = findViewById(R.id.registerText);
        TextView username = findViewById(R.id.loginUser);
        TextView password = findViewById(R.id.loginPass);
        dBase = FirebaseFirestore.getInstance();
        TextView header = findViewById(R.id.header);
        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));



        Button login = findViewById(R.id.loginButton);







        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString();
                String pass = password.getText().toString();
                Map<String, Object> user = new HashMap<>();



                /*
                dBase.collection("user").document(userName).get().addOnSuccessListener(documentSnapshot -> {
                    if(documentSnapshot.exists()){

                        if(documentSnapshot.getString("password").equals(password)){
                            Intent intent = new Intent(getApplicationContext(), Modules.class);
                            intent.putExtra("username", userName);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();

                        }



                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(e -> {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();

                });

                 */



                dBase.collection("admin").whereEqualTo("username", userName).whereEqualTo("password", pass)
                                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if(!queryDocumentSnapshots.isEmpty()){
                                    Intent intent = new Intent(getApplicationContext(), MainAdmin.class);
                                    intent.putExtra("username", userName);
                                    startActivity(intent);
                                }

                                else{
                                    dBase.collection("user").whereEqualTo("username", userName)
                                            .whereEqualTo("password", pass)
                                            .get().
                                            addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                                @Override
                                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                    if(!queryDocumentSnapshots.isEmpty()){

                                                        //To pass a variable to another activity
                                                        Intent intent = new Intent(getApplicationContext(), Modules.class);
                                                        intent.putExtra("username", userName);
                                                        startActivity(intent);



                                                    }
                                                    else{
                                                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();

                                                    }



                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {

                                                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();





                                                }
                                            });

                                }
                            }
                          }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();





                            }
                        });










            }


        });




        /*

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent intent = new Intent(getApplicationContext(), MainAdmin.class);
                intent.putExtra("username", "admin");
                startActivity(intent);







            Intent intent = new Intent(getApplicationContext(), Test1.class);
            intent.putExtra("username", "asd");
            startActivity(intent);









                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);








            }
        });

         */

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });



    }
}