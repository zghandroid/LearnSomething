package com.example.zhang.learnsomething.contentprovider;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 12345 on 2018/7/3.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATEBASENAME = "test.db";
    public static final String USER_TABLE_NAME = "user";
    public static final String JOB_TABLE_NAME = "job";
    private static final int DATEBASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, DATEBASENAME, null, DATEBASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
// 创建两个表格:用户表 和职业表
        db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " name TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + JOB_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " job TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
