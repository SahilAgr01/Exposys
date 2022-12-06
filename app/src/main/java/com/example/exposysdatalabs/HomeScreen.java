package com.example.exposysdatalabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.exposysdatalabs.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity {
    FirebaseAuth mauth;
    public static final String SHARED_PREFS="sharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mauth = FirebaseAuth.getInstance();

//        @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mauth.getCurrentUser();
//        if(user==null){
//            startActivity(new Intent(this,login1.class));
//        }
//
//    }


        MaterialToolbar materialToolbar= (MaterialToolbar) findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.nav_home:
                        Toast.makeText(HomeScreen.this, "Home", Toast.LENGTH_SHORT).show(); break;
                    case R.id.nav_tech:
                        startActivity( new Intent(HomeScreen.this,internactivity0.class));
                        Toast.makeText(HomeScreen.this, "Tech Roles", Toast.LENGTH_SHORT).show(); break;
                    case R.id.nav_non_tech:
                        startActivity( new Intent(HomeScreen.this,NOnTech.class));
                        Toast.makeText(HomeScreen.this, "Non Tech Roles", Toast.LENGTH_SHORT).show(); break;
                    case R.id.nav_logout:
                        //mauth.signOut();
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name","");
                        editor.apply();
                        startActivity( new Intent(getApplicationContext(),login1.class)); finish();
                        Toast.makeText(HomeScreen.this, "Logout", Toast.LENGTH_SHORT).show(); break;

                    case R.id.nav_aboutUs:
                        startActivity( new Intent(HomeScreen.this,AboutUs.class));
                        Toast.makeText(HomeScreen.this,   "About Us", Toast.LENGTH_SHORT).show(); break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
    public void viewAll(View view) {
        Intent intent = new Intent(HomeScreen.this,internactivity0.class);
        startActivity(intent);
    }
    public void nontech(View view) {
        Intent intent = new Intent(HomeScreen.this,NOnTech.class);
        startActivity(intent);
    }
    public void ApplyNow(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://exposysdata.com/registration.php"));
        startActivity(i);
    }
}