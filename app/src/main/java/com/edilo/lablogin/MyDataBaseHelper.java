package com.edilo.lablogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper{


    private Context context;
    private static final String DATABASE_NAME = "penson.db";
    private static final int DAextends SQLiteOpenHelper {


    public MyDataBaseHelper(@Nullable Context activity){
            super(activity, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = activity;
        }

        @Override
        public void onCreate (SQLiteDatabase db){

        }

        @Override
        public void onUpgrade (SQLiteDatabase sqLiteDatabase,int i, int i1){

        }
    }
}
