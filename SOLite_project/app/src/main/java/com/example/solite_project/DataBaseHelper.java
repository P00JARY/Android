package com.example.solite_project;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME="My_database.DB";
    static final int VERSION=1;

    static final String TABLE_NAME="USERS";
    static final String USER_ID="user_ID";
    static final String USER_NAME="user_name";
    static final String USER_PASS="user_pass";

    private static final String CREATE_DB_QUERY="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("
            +USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +USER_NAME+" TEXT NOT NULL,"
            +USER_PASS+" TEXT NOT NULL)";




    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_DB_QUERY);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
}
