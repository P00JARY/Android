package com.example.solite_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {

    DataBaseHelper dataBaseHelper;
    Context context;
    SQLiteDatabase database;


    public DatabaseManager(Context ctx){
        context=ctx;
    }

    public  DatabaseManager Open() throws SQLException{
        dataBaseHelper=new DataBaseHelper(context);
        database=dataBaseHelper.getWritableDatabase();
        return  this;
    }

    public void close(){
        dataBaseHelper.close();
    }

    public void Insert(String username,String password){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DataBaseHelper.USER_NAME,username);
        contentValues.put(DataBaseHelper.USER_PASS,password);
        database.insert(DataBaseHelper.TABLE_NAME,null,contentValues);

    }
    public  long Update(Long _ID,String username,String password){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DataBaseHelper.USER_NAME,username);
        contentValues.put(DataBaseHelper.USER_PASS,password);
        int result =database.update(DataBaseHelper.TABLE_NAME,contentValues, DataBaseHelper.USER_ID + " = "+ _ID,null);
        return  result;
    }

    public  void Delete(Long _ID){
        database.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper.USER_ID +" = "+ _ID,null);
    }

    public Cursor Fetch(){
        String[] columns=new String[]{DataBaseHelper.USER_ID, DataBaseHelper.USER_NAME, DataBaseHelper.USER_PASS};
        Cursor cursor=database.query(DataBaseHelper.TABLE_NAME,columns,null,null,null,null,null);
        if(cursor!=null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
