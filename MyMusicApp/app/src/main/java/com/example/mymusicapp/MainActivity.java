package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;
    private Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.btnPlay);
        stop=(Button)findViewById(R.id.btnStop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==start){
            Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
            startService(new Intent(this,MyService.class));
        }else {
            Toast.makeText(this, "Stoped", Toast.LENGTH_SHORT).show();
            stopService(new Intent(this,MyService.class));
        }
    }
}
