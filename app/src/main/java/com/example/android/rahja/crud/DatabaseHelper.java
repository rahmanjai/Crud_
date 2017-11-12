package com.example.android.rahja.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rahja on 11/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "datasim.db";
    public static final String TABLE_NAME = "mahasiswa";
    public static final String KOLOM_ID = "ID";
    public static final String KOLOM_NAMA = "NAMA";
    public static final String KOLOM_ALAMAT = "ALAMAT";
    public static final String KOLOM_NOTELP ="NOTELP";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER, NAMA TEXT, ALAMAT TEXT, NOTELP INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
    }

    public boolean insertData(String id, String nama, String alamat, String notelp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KOLOM_ID, id);
        contentValues.put(KOLOM_NAMA, nama);
        contentValues.put(KOLOM_ALAMAT, alamat);
        contentValues.put(KOLOM_NOTELP, notelp);
        //long result = db.insert(TABLE_NAME, null, contentValues);

        return true;
    }
}
