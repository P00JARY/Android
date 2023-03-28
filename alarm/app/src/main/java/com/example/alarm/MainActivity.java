package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    EditText datetxt, timetxt;
    Calendar cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datetxt = findViewById(R.id.idDate);
        timetxt = findViewById(R.id.idTime);
        addBtn = findViewById(R.id.idbtn);
        cal = Calendar.getInstance();
        datetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
                        cal.set(Calendar.DAY_OF_MONTH,dayofMonth);
                        cal.set(Calendar.MONTH,month);
                        cal.set(Calendar.YEAR,year);

                        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
                        datetxt.setText(dateFormat.format(cal.getTime()));
                    }
                },year,month,day);
                dateDialog.show();
            }
        });
        timetxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int hour=cal.get(Calendar.HOUR_OF_DAY);
                int minute=cal.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int Currentminute) {
                        cal.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        cal.set(Calendar.MINUTE,Currentminute);
                        SimpleDateFormat timeFormat=new SimpleDateFormat("hh : mm a");
                        timetxt.setText(timeFormat.format(cal.getTime()));

                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AlramRcvr.class);
                PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this,123,intent,0);
                AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC,cal.getTimeInMillis(),pi);
                Toast.makeText(MainActivity.this,"the date n time you choose is"+cal.getTime().toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }
}