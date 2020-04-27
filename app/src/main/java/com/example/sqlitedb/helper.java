package com.example.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlitedb.contract;

public class helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "my_student.db";
    public static final int DATABASE_VERSION = 1;

    public helper(Context context ){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_EN = "CREATE TABLE "+ contract.StudentEntry.TABLE_NAME + " ("
            + contract.StudentEntry._ID + "INTEGER PRIMARY KEY , "+
            contract.StudentEntry.COLUMN_NAME + " TEXT , "+  contract.StudentEntry.COLUMN_COURSE + " TEXT )";

        db.execSQL(SQL_CREATE_EN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIATS" + contract.StudentEntry.TABLE_NAME);
        onCreate(db);
    }
}
