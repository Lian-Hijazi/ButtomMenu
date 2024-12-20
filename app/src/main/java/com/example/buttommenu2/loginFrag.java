package com.example.buttommenu2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginFrag extends Fragment {
    private TextInputEditText et_email, et_password;
    private Button btn_submit, signBtn;
    private FirebaseAuth mAuth;

    public loginFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_login, container, false);
        signBtn=view.findViewById(R.id.signButton2);
        et_email=view.findViewById(R.id.et_email);
        et_password=view.findViewById(R.id.et_password);
        btn_submit=view.findViewById(R.id.submitButton);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailPass();
            }
        });

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.Home_frame.setVisibility(View.INVISIBLE);
                MainActivity.DashBoard_frame.setVisibility(View.INVISIBLE);
                MainActivity.Login_frame.setVisibility(View.INVISIBLE);
                MainActivity.sign_frame.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
    public void checkEmailPass(){
        String email,password;
        email=et_email.getText().toString();
        password=et_password.getText().toString();
        if(!(email.equals("")||password.equals(""))) {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getActivity(), "login seccessful", Toast.LENGTH_SHORT).show();
                        MainActivity.Home_frame.setVisibility(View.VISIBLE);
                        MainActivity.DashBoard_frame.setVisibility(View.INVISIBLE);
                        MainActivity.Login_frame.setVisibility(View.INVISIBLE);
                        MainActivity.sign_frame.setVisibility(View.INVISIBLE);
                        MainActivity.isLog=true;
                        et_email.setText("");
                        et_password.setText("");
                        }

                    else
                        Toast.makeText(getActivity(), "login failed", Toast.LENGTH_SHORT).show();



                }
            });
        }
        else {
            Toast.makeText(getActivity(), "pleas fill fields", Toast.LENGTH_SHORT).show();
        }

        }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        if(currentUser!=null)
            updateUI();
    }
    
    public void updateUI(){
        MainActivity.isLog=true;
        MainActivity.Home_frame.setVisibility(View.VISIBLE);
        MainActivity.DashBoard_frame.setVisibility(View.INVISIBLE);
        MainActivity.Login_frame.setVisibility(View.INVISIBLE);
    }
}
