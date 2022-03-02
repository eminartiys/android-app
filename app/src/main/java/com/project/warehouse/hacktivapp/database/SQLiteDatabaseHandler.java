package com.project.warehouse.hacktivapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.warehouse.hacktivapp.model.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by eminartiys on 22/02/22.
 */

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    // Database version
    private static final int DATABASE_VERSION = 1;
    // Database name
    private static final String DATABASE_NAME = "HacktivApp";

    // Region table user
    private static final String TABLE_USER = "user";
    // user table column
    private static final String USER_ID = "user_id";
    private static final String USER_USERNAME = "user_username";
    private static final String USER_NAME = "user_name";
    private static final String USER_PASSWORD = "user_password";
    // query to create table user
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + USER_ID + " INTEGER PRIMARY KEY, " + USER_USERNAME + " TEXT,"
            + USER_NAME + " TEXT," + USER_PASSWORD + " TEXT" + ")";
    // query to drop/delete table user
    private static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    private static final String TABLE_CATEGORY = "category";
    // user table column
    private static final String CATEGORY_ID = "category_id";
    private static final String CATEGORY_NAME = "category_name";
    // query to create table category
    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
            + CATEGORY_ID + " INTEGER PRIMARY KEY, " + CATEGORY_NAME + " TEXT" + ")";
    // query to drop/delete table user
    private static final String DROP_CATEGORY_TABLE = "DROP TABLE IF EXISTS " + TABLE_CATEGORY;

    public SQLiteDatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creating table
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    // Create-Read-Update-Delete Operation for table user
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_USERNAME, user.getUsername());
        values.put(USER_NAME, user.getName());
        values.put(USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;

        Cursor cursor = db.query(TABLE_USER, new String[] {USER_ID, USER_USERNAME, USER_NAME, USER_PASSWORD},
                                 USER_USERNAME + " =? ", new String[]{username}, null, null, null, null);
        if (cursor.moveToFirst()) {
            user = new User();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setUsername(cursor.getString(1));
            user.setName(cursor.getString(2));
            user.setPassword(cursor.getString(3));
        }

        return user;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setName(cursor.getString(2));
                user.setPassword(cursor.getString(3));

                users.add(user);
            } while (cursor.moveToNext());
        }

        return users;
    }
}
