package com.example.airlearn;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    FirebaseFirestore dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.moduleTestHeader), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView firstName = findViewById(R.id.registerFirstName);
        TextView lastName = findViewById(R.id.registerLastName);
        EditText birthDate = findViewById(R.id.registerBirthDate);
        TextView username = findViewById(R.id.registerUser);
        TextView password = findViewById(R.id.registerPass);
        TextView retype = findViewById(R.id.registerRetype);
        TextView loginText = findViewById(R.id.loginText);
        dBase = FirebaseFirestore.getInstance();
        TextView header = findViewById(R.id.registerHeader);
        header.setBackgroundColor(Color.parseColor("blue"));
        header.setTextColor(Color.parseColor("white"));


        Button register = findViewById(R.id.registerButton);

        //Button login = findViewById(R.id.registerLogin);



        birthDate.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private final String slash = "/";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed before text change
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No action needed while text is being changed
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.equals(current)) {
                    String cleanString = input.replaceAll("[^\\d]", ""); // Remove non-digits
                    StringBuilder formatted = new StringBuilder();

                    for (int i = 0; i < cleanString.length(); i++) {
                        if (i == 2 || i == 4) {
                            formatted.append(slash); // Add slash after month and day
                        }
                        formatted.append(cleanString.charAt(i));
                    }

                    // Limit to 10 characters (mm/dd/yyyy)
                    if (formatted.length() > 10) {
                        formatted.setLength(10);
                    }

                    current = formatted.toString();
                    birthDate.setText(current);
                    birthDate.setSelection(current.length()); // Move cursor to end
                }
            }
        });

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a DatePickerDialog
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                // Set the selected date in the TextView
                                birthDate.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString();
                String pass = password.getText().toString();
                String userFirstName = firstName.getText().toString();
                String userLastName = lastName.getText().toString();
                String userBirthDate = birthDate.getText().toString();
                String userRetype = retype.getText().toString();
                Map<String, Object> user = new HashMap<>();


                dBase.collection("user").whereEqualTo("username", userName).get().
                        addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if(!queryDocumentSnapshots.isEmpty()) {
                                    Toast.makeText(Register.this, "Username already exist, change your username", Toast.LENGTH_LONG).show();
                                }
                                if(userName.isEmpty() || pass.isEmpty() || userFirstName.isEmpty() || userLastName.isEmpty() || userBirthDate.isEmpty() || userRetype.isEmpty()){
                                    Toast.makeText(Register.this, "Input all fields", Toast.LENGTH_LONG).show();
                                }
                                else if(!pass.equals(userRetype)){
                                    Toast.makeText(Register.this, "Password doesn't match", Toast.LENGTH_LONG).show();

                                }
                                else{
                                    user.put("First Name", userFirstName);
                                    user.put("Last Name", userLastName);
                                    user.put("Birth Date", userBirthDate);
                                    user.put("username", userName);
                                    user.put("password", pass);
                                    user.put("quiz1", 0);
                                    user.put("quiz2", 0);
                                    user.put("quiz3", 0);
                                    user.put("quiz4", 0);
                                    user.put("quiz5", 0);
                                    user.put("quiz6", 0);





                                    dBase.collection("user").document(userName).set(user).
                                            addOnSuccessListener(aVoid ->  {
                                                    Toast.makeText(Register.this, "Successful", Toast.LENGTH_LONG).show();


                                                })
                                            .addOnFailureListener(e -> {
                                                    Toast.makeText(Register.this, "Failed", Toast.LENGTH_LONG).show();
                                            });

                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(Register.this, "Error", Toast.LENGTH_LONG).show();





                            }
                        });




            }


        });

        /*
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

         */

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}