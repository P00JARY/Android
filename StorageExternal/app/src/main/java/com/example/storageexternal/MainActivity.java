package com.example.storageexternal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    String filePath="MyFile_dir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.idtext1);
        editText2=findViewById(R.id.idtext);


    }

    public void setData(View view) {
        if(isOK()) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
            }
            File txtFile = new File(getExternalFilesDir(filePath), editText1.getText().toString());
            String data = editText2.getText().toString();
            try {
                FileOutputStream fos = new FileOutputStream(txtFile);
                fos.write(data.getBytes());
                editText2.setText("");
                fos.close();
                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


    }

    public void getData(View view) {

        FileInputStream fis=null;
        File txt = new File(getExternalFilesDir(filePath), editText1.getText().toString());
        try {
            fis=new FileInputStream(txt);
            String s="";
            int data2;
            while ((data2=fis.read())!=-1){
                s=s+(char)data2;
            }
            editText2.setText("FROM FILE:\n"+s);
            Toast.makeText(this, "hello working", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public boolean isOK(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            return true;
        }else {
            return false;
        }
    }

}