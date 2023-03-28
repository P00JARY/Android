package com.example.sharedpref_exp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secnd_activity extends AppCompatActivity {


    EditText editText1,editText2;
    SharedPreferences sharedPreferences;

    public  static  final String SHARED_PREF_NAME="MyPref";
    public  static  final String KEY_NAME="name";
    public  static  final String KEY_EMAIL="email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secnd);

        editText1=findViewById(R.id.idEdit);
        editText2=findViewById(R.id.idEdit02);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        String str1=sharedPreferences.getString(KEY_NAME,"");
        String str2=sharedPreferences.getString(KEY_EMAIL,"");

        editText1.setText(str1);
        editText2.setText(str2);

    }
    public void onCLick02(View view){
        sharedPreferences.edit().clear().commit();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}