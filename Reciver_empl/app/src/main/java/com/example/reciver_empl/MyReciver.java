package com.example.reciver_empl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class MyReciver extends BroadcastReceiver {
    TextView img;
    TextView txt;

    MyReciver(TextView img, TextView txt){
        this.img=img;
        this.txt=txt;
    }
    @Override
    public void onReceive(Context context, Intent intent) {

        int percentage=intent.getIntExtra("level",0);
        if(percentage<21){
            txt.setText("onthe charge g deepara :(");
        }
        if(percentage==69) {
            txt.setText("Hey Hey "+percentage+":)");

        } else
        {
            txt.setText(""+percentage+"%");
        }

    }
}
