package com.example.project01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Add_b,Sub_b,mul_b,div_b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add_b=findViewById(R.id.b1_main);
        Add_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replayce(new Addition());
            }
        });
        Sub_b=findViewById(R.id.b2_main);
        Sub_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replayce(new Subtraction());
            }
        });
        mul_b=findViewById(R.id.b4_main);
        mul_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replayce(new Multiply());
            }
        });
        div_b=findViewById(R.id.b3_main);
        div_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replayce(new division());
            }
        });
    }
    protected void replayce(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}