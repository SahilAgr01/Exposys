package com.example.exposysdatalabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginAct extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      //  ProgressDialog progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        EditText email = (EditText) findViewById(R.id.editTextAddress);
        EditText name = (EditText) findViewById(R.id.editNAme);
        EditText password = (EditText) findViewById(R.id.editPassword);
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";


        Button SignUp = (Button) findViewById(R.id.signUP);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emails = email.getText().toString();
                String names = name.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(emails)){
                    email.setError("Enter Correct Email");
                }
                else if(TextUtils.isEmpty(pass) ){
                    password.setError("Password min length 6 !");
                    password.requestFocus();
                }
                else{

                    mAuth.createUserWithEmailAndPassword(emails,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(loginAct.this, "Registration Sucessful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(loginAct.this,HomeScreen.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                            }
                            else {
                              //  progressDialog.dismiss();
                                Toast.makeText(loginAct.this, "Error in Registration"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }

    public void signIn(View view) {
        Intent intent = new Intent(loginAct.this,login1.class);
        startActivity(intent);
    }

}