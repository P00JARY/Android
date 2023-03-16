package com.example.paytm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class History extends AppCompatActivity {


    public RecyclerView RV;
    public TextView display,his;
    public String data="";

    ArrayList<String> QR_data;
    ArrayList<String> ID;

    public MyDbManager db_manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        display=findViewById(R.id.dataDisplay);

        db_manager=new MyDbManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db_manager.Open();
        Cursor cursor=db_manager.Fetch();
       if(cursor.moveToFirst()){
           do{
               data=data + cursor.getString(cursor.getColumnIndexOrThrow(MyHelper.QR_ID))+" \t ";
               data=data + cursor.getString(cursor.getColumnIndexOrThrow(MyHelper.QR_DATA))+" \n\n";

           }while (cursor.moveToNext());
           Log.e("Data From SQL :",data);
           display.setText(data);


       }
       db_manager.close();
    }
}