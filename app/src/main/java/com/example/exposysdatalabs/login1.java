package com.example.exposysdatalabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login1 extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        mAuth = FirebaseAuth.getInstance();
      //  mUser = mAuth.getCurrentUser();

        EditText emailed = (EditText) findViewById(R.id.editmail);
        EditText passwords = (EditText) findViewById(R.id.ediPassword);

        Button SignIn = (Button) findViewById(R.id.signIn);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = emailed.getText().toString();
                String passed = passwords.getText().toString();

                if(TextUtils.isEmpty(mail)){
                    emailed.setError("Enter Correct Email");
                }
                else if(TextUtils.isEmpty(passed) ){
                    passwords.setError("Password min length 6 !");
                    passwords.requestFocus();
                }
                else{
                    mAuth.signInWithEmailAndPassword(mail,passed).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(login1.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login1.this,HomeScreen.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(login1.this, "email not Registered"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });


    }


}