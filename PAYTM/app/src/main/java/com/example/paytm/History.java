package com.example.paytm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class History extends AppCompatActivity {


    public RecyclerView RV;

    ArrayList<String> QR_data;
    ArrayList<String> ID;

    public MyDbManager db_manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RV=findViewById(R.id.RV);
        QR_data=new ArrayList<>();
        ID=new ArrayList<>();
        db_manager=new MyDbManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db_manager.Open();
        Cursor cursor=db_manager.Fetch();
       if(cursor.moveToFirst()){
           do{
               ID.add(cursor.getString(cursor.getColumnIndexOrThrow(MyHelper.QR_ID)));
               QR_data.add(cursor.getString(cursor.getColumnIndexOrThrow(MyHelper.QR_DATA)));

               Log.e("VALUE : ",cursor.getString(cursor.getColumnIndexOrThrow(MyHelper.QR_ID)));
               Log.e("VALUE : ",cursor.getString(cursor.getColumnIndexOrThrow(MyHelper.QR_DATA)));
           }while (cursor.moveToNext());
       }
       db_manager.close();
    }
}