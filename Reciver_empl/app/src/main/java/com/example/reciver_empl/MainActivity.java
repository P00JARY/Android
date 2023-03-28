package com.example.reciver_empl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ig;
    TextView txt;

    MyReciver myReciver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ig=findViewById(R.id.image);
        txt=findViewById(R.id.txt1);
        myReciver=new MyReciver(ig,txt);
        registerReceiver(myReciver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));



    }
}