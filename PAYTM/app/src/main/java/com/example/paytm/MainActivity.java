package com.example.paytm;


import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {

    Button scan,history;

    public MyDbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbManager=new MyDbManager(this);

       try {
           dbManager.Open();
       }catch (Exception er){
           Log.e("erro in Open() : ",""+er);
       }


    }

    protected void scanQR(){
        ScanOptions scanOptions=new ScanOptions();
        scanOptions.setPrompt("place ur phone!");
        scanOptions.setBeepEnabled(true);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(ScannedQR.class);
        resultLauncher.launch(scanOptions);
    }

    ActivityResultLauncher<ScanOptions> resultLauncher = registerForActivityResult(new ScanContract(),result -> {
        if(result.getContents()!=null){
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Scanned QR-Code DATA!");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
            String url=result.getContents();
            dbManager.Insert(url);
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
    });

    public void scanCode(View view) {
        Toast.makeText(this, "Scanning QR-Code...", Toast.LENGTH_SHORT).show();
        scanQR();
    }

    public void viewQRdate(View view) {
        Intent i=new Intent(MainActivity.this,History.class);
        startActivity(i);
    }
}
