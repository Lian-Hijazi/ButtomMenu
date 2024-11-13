package com.example.buttommenu2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public static FrameLayout Home_frame,DashBoard_frame,Login_frame;
    public static homeFrag homeFrag;
    public static dashFrag dashFrag;
    public static loginFrag loginFrag;
    private BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Home_frame=findViewById(R.id.home_Frame);
        DashBoard_frame=findViewById(R.id.dash_Frame);
        Login_frame=findViewById(R.id.login_Frame);
        bottom_navigation=findViewById(R.id.bottom_navigation);

        startFragment();

    }
    public void startFragment() {
        homeFrag = new homeFrag();
        dashFrag = new dashFrag();
        loginFrag = new loginFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_Frame, homeFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.dash_Frame, dashFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.login_Frame, loginFrag).commit();
        //hide other fragments
        Login_frame.setVisibility(View.INVISIBLE);
        DashBoard_frame.setVisibility(View.INVISIBLE);
        //set up navigation View listener
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    Home_frame.setVisibility(View.VISIBLE);
                    DashBoard_frame.setVisibility(View.INVISIBLE);
                    Login_frame.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId() == R.id.menu_dashboard) {
                    Home_frame.setVisibility(View.INVISIBLE);
                    DashBoard_frame.setVisibility(View.VISIBLE);
                    Login_frame.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId() == R.id.menu_login) {
                    Home_frame.setVisibility(View.INVISIBLE);
                    DashBoard_frame.setVisibility(View.INVISIBLE);
                    Login_frame.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });
    }

    }