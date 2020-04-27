package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper mDbHelper = new helper(this);

       SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String[] pro = { contract.StudentEntry._ID ,contract.StudentEntry.COLUMN_NAME , contract.StudentEntry.COLUMN_COURSE };
        
        String selection = contract.StudentEntry.COLUMN_NAME + " = ?";
        String[] selectionArgs = {"Ali"};

        String sortOrder = contract.StudentEntry._ID + " DESC";

        Cursor cursor = db.query(contract.StudentEntry.TABLE_NAME, pro , selection,selectionArgs , null , null ,sortOrder);

        if(cursor.moveToFirst()){
            do{
                Toast.makeText(this, cursor.getString(cursor.getColumnIndex(contract.StudentEntry._ID)), Toast.LENGTH_SHORT).show();
            } while (cursor.moveToNext());
        }


        ContentValues values = new ContentValues();
        values.put(contract.StudentEntry.COLUMN_NAME , "Ali");


        long newRowId = db.insert(contract.StudentEntry.TABLE_NAME,null , values);

        if(newRowId == -1){
            Toast.makeText(this, "Error With Saving Student", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Student Save With Row ID : "+newRowId, Toast.LENGTH_SHORT).show();
        }

    }


}
