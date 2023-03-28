package com.example.notif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyBtn=findViewById(R.id.idNotfy);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {

            NotificationChannel channel=new NotificationChannel("Notification","Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"Notification");
                builder.setContentTitle("My title")
                        .setContentText("How are you")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });

    }
}