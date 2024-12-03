package com.example.buttommenu2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;


public class homeFrag extends Fragment {
    private FloatingActionButton btn_logout;


    public homeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        btn_logout=view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOut();
            }
        });
        return view;
    }

    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
        MainActivity.isLog=false;
        MainActivity.Home_frame.setVisibility(View.INVISIBLE);
        MainActivity.DashBoard_frame.setVisibility(View.INVISIBLE);
        MainActivity.Login_frame.setVisibility(View.VISIBLE);
    }
}