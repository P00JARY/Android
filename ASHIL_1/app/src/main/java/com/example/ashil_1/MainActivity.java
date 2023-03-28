package com.example.ashil_1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText First,sec;
    TextView res;
    Button add,mul,div,sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        First=findViewById(R.id.num_first);
        sec=findViewById(R.id.num_Two);
        res=findViewById(R.id.result);
        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(First.getText().toString());
                int num2 = Integer.parseInt(sec.getText().toString());
                int sum = num1 + num2;
                res.setText("" + sum + "");
            }
        });
        sub=findViewById(R.id.button2);
        sub.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(First.getText().toString());
                int num2 = Integer.parseInt(sec.getText().toString());
                int sub = num1 - num2;
                res.setText("" + sub + "");
            }
        });
        mul=findViewById(R.id.button3);
        mul.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(First.getText().toString());
                int num2 = Integer.parseInt(sec.getText().toString());
                int mul = num1 * num2;
                res.setText("" + mul + "");
            }
        });
        div=findViewById(R.id.button4);
        div.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(First.getText().toString());
                int num2 = Integer.parseInt(sec.getText().toString());
                int div = num1 / num2;
                res.setText("" + div + "");
            }
        });

    }
}