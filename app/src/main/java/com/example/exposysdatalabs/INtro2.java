package com.example.exposysdatalabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class INtro2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
    }

    public void nextTab(View view) {
        Intent intent = new Intent(INtro2.this,loginAct.class);
        startActivity(intent);
        finish();
    }
}