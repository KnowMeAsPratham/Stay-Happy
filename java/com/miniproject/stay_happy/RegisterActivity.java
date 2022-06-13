package com.miniproject.stay_happy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText user_name,user_email,user_contact,user_pass,user_confirm_pass;
    Button sign_up;

    String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
    String phone_pattern = "[789][0-9]{9}";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user_name = findViewById(R.id.user_name);
        user_email = findViewById(R.id.user_email);
        user_contact = findViewById(R.id.user_contact);
        user_pass = findViewById(R.id.user_pass);
        user_confirm_pass = findViewById(R.id.user_confirm_pass);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        sign_up = findViewById(R.id.sign_in);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {

        String email = user_email.getText().toString().trim();
        String username = user_name.getText().toString().trim();
        String phone = user_contact.getText().toString().trim();
        String password = user_pass.getText().toString().trim();
        String confirm_password = user_confirm_pass.getText().toString().trim();

        if (!email.matches(email_pattern))
        {
            user_email.setError("Enter correct email id");
        }
        else if(username.isEmpty() || username.length()<2)
        {
            user_name.setError("Please enter valid username");
        }
        else if(!phone.matches(phone_pattern) || phone.length()<10)
        {
            user_contact.setError("Please enter a valid 10 digit number");
        }
        else if(password.isEmpty() || password.length()<6)
        {
            user_pass.setError("Enter Proper password");
        }
        else if(!password.equals(confirm_password))
        {
            user_confirm_pass.setError("Password Does not match");
        }
        else
        {
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}