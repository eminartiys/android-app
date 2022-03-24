package com.project.warehouse.hacktivapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.warehouse.hacktivapp.model.Category;
import com.project.warehouse.hacktivapp.model.Product;
import com.project.warehouse.hacktivapp.model.SubCategory;
import com.project.warehouse.hacktivapp.model.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by eminartiys on 22/02/22.
 */

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    // Database name
    private static final String DATABASE_NAME = "HacktivAppDB";
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Region table user
    private static final String TABLE_USER = "user";
    // user table column
    private static final String USER_ID = "user_id";
    private static final String USER_USERNAME = "username";
    private static final String USER_NAME = "name";
    private static final String USER_PHONENUMBER = "phone_number";
    private static final String USER_PASSWORD = "password";
    private static final String USER_ROLE = "role";
    // query to create table user
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_USERNAME + " TEXT,"
            + USER_NAME + " TEXT," + USER_PHONENUMBER + " TEXT," + USER_PASSWORD + " TEXT," + USER_ROLE + " TEXT" + ")";
    // query to drop/delete table user
    private static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    // Region table category
    private static final String TABLE_CATEGORY = "category";
    // category table column
    private static final String CATEGORY_ID = "category_id";
    private static final String CATEGORY_NAME = "name";
    private static final String CATEGORY_IMAGE = "image";
    // query to create table category
    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
            + CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CATEGORY_NAME + " TEXT, " + CATEGORY_IMAGE + " TEXT" +")";
    // query to drop/delete table user
    private static final String DROP_CATEGORY_TABLE = "DROP TABLE IF EXISTS " + TABLE_CATEGORY;

    // Region table subcategory
    private static final String TABLE_SUBCATEGORY = "subcategory";
    // subcategory table column
    private static final String SUBCATEGORY_ID = "subcategory_id";
    private static final String SUBCATEGORY_NAME = "name";
    private static final String SUBCATEGORY_IMAGE = "image";
    private static final String SUBCATEGORY_PARENTID = "parent_category_id";
    // query to create table category
    private static final String CREATE_SUBCATEGORY_TABLE = "CREATE TABLE " + TABLE_SUBCATEGORY + "("
            + SUBCATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBCATEGORY_NAME + " TEXT, " + SUBCATEGORY_IMAGE + " TEXT, "
            + SUBCATEGORY_PARENTID + " TEXT" +")";
    // query to drop/delete table user
    private static final String DROP_SUBCATEGORY_TABLE = "DROP TABLE IF EXISTS " + TABLE_SUBCATEGORY;

    // Region table product
    private static final String TABLE_PRODUCT = "product";
    // product table column
    private static final String PRODUCT_ID = "product_id";
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_QUANTITY = "quantity";
    private static final String PRODUCT_IMAGE = "image";
    private static final String PRODUCT_DESCRIPTION = "description";
    // query to create table product
    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
            + PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PRODUCT_NAME + " TEXT, " + PRODUCT_QUANTITY + " INT, "
            + PRODUCT_IMAGE + " TEXT, " + PRODUCT_DESCRIPTION + " TEXT" +")";
    // query to drop/delete table user
    private static final String DROP_PRODUCT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PRODUCT;

    public SQLiteDatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creating table
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_SUBCATEGORY_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_CATEGORY_TABLE);
        db.execSQL(CREATE_SUBCATEGORY_TABLE);
        db.execSQL(DROP_PRODUCT_TABLE);
        onCreate(db);
    }

    // Create-Read-Update-Delete Operation for table user
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_USERNAME, user.getUsername());
        values.put(USER_NAME, user.getName());
        values.put(USER_PHONENUMBER, user.getPhoneNumber());
        values.put(USER_PASSWORD, user.getPassword());
        values.put(USER_ROLE, user.getRole());

        db.insert(TABLE_USER, null, values);
    }

    public User getUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " +  USER_ID + " = " + id;
        User user = null;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            user = new User();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setUsername(cursor.getString(1));
            user.setName(cursor.getString(2));
            user.setPhoneNumber(cursor.getString(3));
            user.setPassword(cursor.getString(4));
            user.setRole(cursor.getString(5));
        }

        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " +  USER_USERNAME + " = '" + username + "' AND " + USER_PASSWORD + " = '" + password + "'";
        User user = null;

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            user = new User();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setUsername(cursor.getString(1));
            user.setName(cursor.getString(2));
            user.setPhoneNumber(cursor.getString(3));
            user.setPassword(cursor.getString(4));
            user.setRole(cursor.getString(5));
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
                user.setPhoneNumber(cursor.getString(3));
                user.setPassword(cursor.getString(4));
                user.setRole(cursor.getString(5));

                users.add(user);
            } while (cursor.moveToNext());
        }

        return users;
    }

    // Create-Read-Update-Delete Operation for table category
    public void addCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CATEGORY_NAME, category.getName());
        values.put(CATEGORY_IMAGE, category.getImage());

        db.insert(TABLE_CATEGORY, null, values);
    }

    // Create-Read-Update-Delete Operation for table subcategory
    public void addSubCategory(SubCategory subcategory) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUBCATEGORY_NAME, subcategory.getName());
        values.put(SUBCATEGORY_IMAGE, subcategory.getImage());
        values.put(SUBCATEGORY_PARENTID, subcategory.getParentCategoryId());

        db.insert(TABLE_SUBCATEGORY, null, values);
    }

    // Create-Read-Update-Delete Operation for table product
    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME, product.getName());
        values.put(PRODUCT_QUANTITY, product.getQuantity());
        values.put(PRODUCT_IMAGE, product.getImage());
        values.put(PRODUCT_DESCRIPTION, product.getDescription());

        db.insert(TABLE_PRODUCT, null, values);
    }
}
