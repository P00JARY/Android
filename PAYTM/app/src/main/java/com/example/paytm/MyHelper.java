package com.example.paytm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME="My_database.DB";
    static final int VERSION=1;

    static final String TABLE_NAME="OQ_TABLE";
    static final String QR_ID="_ID";
    static final String QR_DATA="DATA";

    public static String CREATE_DB_QUERY="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("
            +QR_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +QR_DATA+" TEXT NOT NULL)";

    public MyHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int ii) {
        sqLiteDatabase.execSQL("Drop table if exists "+TABLE_NAME);
        sqLiteDatabase.execSQL(CREATE_DB_QUERY);
    }
}
