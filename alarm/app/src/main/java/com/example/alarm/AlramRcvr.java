package com.example.alarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class AlramRcvr extends BroadcastReceiver {

    NotificationManager manager;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "Alarm is set", Toast.LENGTH_SHORT).show();
        manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel=new NotificationChannel("MY_Channel","Reminders",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(notificationChannel);
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("www.google.com"));
            PendingIntent pi= PendingIntent.getActivity(context,123,i,0);


            Uri ringToneUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            MediaPlayer mp= MediaPlayer.create(context,ringToneUri);
            mp.start();
            NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"My_channel");
            builder.setContentTitle("My Notification")
                    .setContentText("Alarm Notification")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setContentIntent(pi)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .setSound(ringToneUri);
            manager.notify(456, builder.build());



        }

    }
}
