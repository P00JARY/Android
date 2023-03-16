package com.example.paytm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDbManager {

    MyHelper myHelper;
    Context context;
    SQLiteDatabase database;

    public MyDbManager(Context context) {
        this.context = context;
        Log.d("", MyHelper.CREATE_DB_QUERY);
    }


    public MyDbManager Open() throws SQLException {
        myHelper=new MyHelper(context);
        database=myHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        myHelper.close();
    }

    public void Insert(String OR_URL){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyHelper.QR_DATA,OR_URL);
        Log.e("", contentValues.toString());
        long l= database.insert(MyHelper.TABLE_NAME,null,contentValues);
        if(l>0){
            Log.e("","Inserted");
        }else {
            Log.e("","Failed");
        }

    }

    public Cursor Fetch(){
        String[] columns=new String[]{myHelper.QR_ID, myHelper.QR_DATA};
        Cursor cursor=database.query(myHelper.TABLE_NAME,columns,null,null,null,null,null);
        if(cursor!=null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
