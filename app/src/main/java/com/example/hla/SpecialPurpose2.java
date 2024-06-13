package com.example.hla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpecialPurpose2 extends AppCompatActivity {
    private EditText passwordEditText;
    private Button proceedButton;
    private static final String CORRECT_PASSWORD = "MoneyHeist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_special_purpose2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        passwordEditText = findViewById(R.id.passwordEditText);
        proceedButton = findViewById(R.id.proceedButton);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredPassword = passwordEditText.getText().toString();

                if (enteredPassword.equals(CORRECT_PASSWORD)) {
                    Intent intent = new Intent(SpecialPurpose2.this, SpecialPurpose3.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SpecialPurpose2.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}