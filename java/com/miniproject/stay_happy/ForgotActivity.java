package com.miniproject.stay_happy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    Button forgot_btn;
    EditText for_email;
    String email;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        auth = FirebaseAuth.getInstance();

        for_email = findViewById(R.id.forgot_password_email);
        forgot_btn = findViewById(R.id.forgot_button);

        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateDate();
            }
        });
    }

    private void validateDate() {
        email = for_email.getText().toString().trim();
        if (email.isEmpty())
        {
            for_email.setError("Required");
        }
        else
        {
            forgotPass();
        }
    }

    private void forgotPass() {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(ForgotActivity.this, "Reset link has been send to your email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotActivity.this,LoginActivity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(ForgotActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}