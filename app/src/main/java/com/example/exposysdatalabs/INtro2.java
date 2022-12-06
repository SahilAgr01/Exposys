package com.example.exposysdatalabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class INtro2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mauth.getCurrentUser();
//        if(user==null){
//            startActivity(new Intent(this,login1.class));
//        }
//
//    }

    public void nextTab(View view) {
        Intent intent = new Intent(INtro2.this,loginAct.class);
        startActivity(intent);
        finish();
    }
}