package com.example.ashil_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Name,Password;
    Button login;
    TextView msg;
    private  int flag=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.etName);
        Password=findViewById(R.id.etPassword);
        login=findViewById(R.id.btLogin);
        msg=findViewById(R.id.txtmsg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    private void validate(String usName,String usPassword){
        if(usName.equals("Ashil")&&usPassword.equals("123456")){
            Intent intent =new Intent(MainActivity.this,login_page2.class);
            startActivity(intent);
        }else{
            flag--;
            msg.setText(flag+" attemps left!");
            if(flag==0){
                login.setEnabled(false);
                msg.setText("Too many unsuccessfull attemps!");
            }

        }


    }
}

