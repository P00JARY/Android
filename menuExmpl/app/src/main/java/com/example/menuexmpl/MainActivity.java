package com.example.menuexmpl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclick1(View view){
        setContentView(R.layout.scnd);
    }

    public void onclick2(View view){
        setContentView(R.layout.activity_main);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.mymenu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected( MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.item1:
//                Toast.makeText(this,"hey boy hehehehe",Toast.LENGTH_SHORT).show();
//                return super.onOptionsItemSelected(item);
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("CLICK");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString()){
            case "CLICK":
                Toast.makeText(this,"hey boy hehehehe",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}