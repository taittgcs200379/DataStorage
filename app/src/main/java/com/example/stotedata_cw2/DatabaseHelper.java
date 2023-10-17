package com.example.stotedata_cw2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "user_details";
    public static final  String TABLE_NAME="creating_details";
    public static final String COLUMN_ID="user_id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_DOB="dob";
    public static final String COLUMN_EMAIL="email";

    private SQLiteDatabase database;

    private static final String DETAILS_TABLE= String.format(
            "CREATE TABlE %s(" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT, " +
                    "%s TEXT, " +
                    "%s TEXT)",
            TABLE_NAME, COLUMN_ID, COLUMN_NAME, COLUMN_DOB, COLUMN_EMAIL);

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        database = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DETAILS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + DATABASE_NAME);
        Log.w(this.getClass().getName(), DATABASE_NAME +"database upgrade to version" + newVersion + "-old data lost");
        onCreate(db);
    }
    public long insertDetails(String name, String dob, String email){
        ContentValues rowValues = new ContentValues();
        rowValues.put(COLUMN_NAME, name);
        rowValues.put(COLUMN_DOB, dob);
        rowValues.put(COLUMN_EMAIL, email);
        return database.insertOrThrow(TABLE_NAME, null, rowValues);
    }
    public ArrayList<DetailModel> getAllData(){
        ArrayList<DetailModel> arrayList =new ArrayList<>();
        String selectQuery=" SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                DetailModel detailModel = new DetailModel(
                        ""+cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DOB)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL))

                );
                arrayList.add(detailModel);
            }while (cursor.moveToNext());

        }
        db.close();
        return arrayList;
    }
}
