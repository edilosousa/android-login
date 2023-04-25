package com.edilo.lablogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "penson.db";

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tbl_names";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FNAME = "fname";
    private static final String COLUMN_LNAME = "lname";
    public MyDataBaseHelper(@Nullable Context activity) {
        super(activity, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = activity;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("+ COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FNAME + " TEXT, " + COLUMN_LNAME + " TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addPerson(String fName, String lName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FNAME, fName);
        cv.put(COLUMN_LNAME, lName);

        long result = db.insert(TABLE_NAME, null, cv);
        if( result == -1){
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor displayAllData() {
        String query = " SELECT * FROM " + TABLE_NAME ;
        //+ " ORDER BY " + COLUMN_FNAME + " ASC LIMIT 5"
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }


}