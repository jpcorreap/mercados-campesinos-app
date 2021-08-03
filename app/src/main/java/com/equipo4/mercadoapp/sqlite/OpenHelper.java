package com.equipo4.mercadoapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.equipo4.mercadoapp.model.User;

public class OpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_mercado.db";
    public static final int DB_VERSION = 1;

    public OpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + User.TABLE + "(" +
                User.USERNAME+" TEXT NOT NULL PRIMARY KEY,"+
                User.NAME+" TEXT NOT NULL,"+
                User.EMAIL+" TEXT NOT NULL UNIQUE,"+
                User.PHONE+" INTEGER NOT NULL,"+
                User.PASSWORD+" TEXT NOT NULL"+
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+User.TABLE);
        onCreate(db);
    }
    public void openDB(){
        getWritableDatabase();
    }
    public void closeDB(){
        this.close();
    }

    public long insert(String table, ContentValues values){
        return getWritableDatabase().insert(table, null, values);
    }
    public int update(String table, ContentValues values, String where){
        return getWritableDatabase().update(table, values, where, null);
    }
    public int delete(String table, String where){
        return getWritableDatabase().delete(table, where, null);
    }
    public Cursor select(String sql, @Nullable String[] whereArgs){
        return getWritableDatabase().rawQuery(sql, whereArgs);
    }
}
