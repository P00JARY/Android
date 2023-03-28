package com.example.solite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userID,userName,userPass;
    DatabaseManager DBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userID=findViewById(R.id.idID);
        userName=findViewById(R.id.idUname);
        userPass=findViewById(R.id.idpass);


        DBManager=new DatabaseManager(this);
    }

    public void onInsert1(View view) {
        DBManager.Insert(userName.getText().toString(),userPass.getText().toString());
    }

    public void onGet(View view) {
        Cursor cursor=DBManager.Fetch();
        if(cursor.moveToFirst()){
            do{
                String id=cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.USER_ID));
                String name=cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.USER_NAME));
                String pass=cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.USER_PASS));
                Log.i("database","user info is :" +id+" usernmae :"+name+" userpass :"+pass);
            }while (cursor.moveToNext());
        }
    }

    public void onDelete(View view) {
        DBManager.Delete(Long.parseLong(userID.getText().toString()));
    }

    public void onUpdate(View view) {
        DBManager.Update(Long.parseLong(userID.getText().toString()),userName.getText().toString(),userPass.getText().toString());

    }
}