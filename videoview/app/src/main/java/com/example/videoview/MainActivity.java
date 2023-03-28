package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    MediaPlayer mp =MediaPlayer.create(this, Uri.parse("https://www.youtube.com/watch?v=WsnlrU1uWH0&ab_channel=NinjaPal"));
    

}