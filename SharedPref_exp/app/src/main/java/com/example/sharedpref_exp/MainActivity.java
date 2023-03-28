package com.example.sharedpref_exp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    EditText text1,text2;
    Button btn;

    public  static  final String SHARED_PREF_NAME="MyPref";
    public  static  final String KEY_NAME="name";
    public  static  final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=findViewById(R.id.idEdit1);
        text2=findViewById(R.id.idEdit2);
        btn=findViewById(R.id.idBtn);

        pref=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


    }

    public void click1(View view){
        String str1=text1.getText().toString();
        String str2=text2.getText().toString();

        SharedPreferences.Editor prefEditor=pref.edit();

        prefEditor.putString(KEY_NAME,str1);
        prefEditor.putString(KEY_EMAIL,str2);
        prefEditor.commit();

        Intent i=new Intent(MainActivity.this,secnd_activity.class);
        startActivity(i);


    }
}