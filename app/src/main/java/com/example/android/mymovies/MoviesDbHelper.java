package com.example.android.mymovies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by SIPADALA on 2/25/2018.
 */

public class MoviesDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "mymovies.db";
    private static final int DATABASE_VERSION = 1;

    public MoviesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + MovieDbContract.MovieDb.TABLE_NAME + " (" +
                MovieDbContract.MovieDb._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieDbContract.MovieDb.COLUMN_MOVIE_ID+ " INTEGER NOT NULL," +
                MovieDbContract.MovieDb.COLUMN_MOVIE_NAME + " TEXT NOT NULL, " +
                MovieDbContract.MovieDb.COLUMN_POSTER_ID + " TEXT NOT NULL, " +
                MovieDbContract.MovieDb.COLUMN_OVERVIEW + " TEXT NOT NULL, " +
                MovieDbContract.MovieDb.COLUMN_RELEASE_DATE + " TEXT NOT NULL, " +
                MovieDbContract.MovieDb.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                "); ";
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieDbContract.MovieDb.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}