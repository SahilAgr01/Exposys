package com.example.exposysdatalabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class NOnTech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_tech);
    }
    public void ApplynT(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://exposysdata.com/registration.php"));
        startActivity(i);
    }
}