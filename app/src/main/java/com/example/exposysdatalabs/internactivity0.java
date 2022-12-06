package com.example.exposysdatalabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class internactivity0 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internactivity0);
    }
    public void Applyhere(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://exposysdata.com/registration.php"));
        startActivity(i);
    }
}