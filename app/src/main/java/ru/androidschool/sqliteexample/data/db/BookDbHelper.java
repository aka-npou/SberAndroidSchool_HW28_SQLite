package ru.androidschool.sqliteexample.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDbHelper extends SQLiteOpenHelper {

    private static final String NAME = "books.db";
    private static final int VERSION = 1;

    public BookDbHelper(Context context) {
        super(context, NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlText = String.format("CREATE TABLE %s (%s integer PRIMARY KEY autoincrement, %s text, %s text, %s text, %s integer)",
                BooksTable.NAME,
                BooksTable.Columns._ID,
                BooksTable.Columns.UUID,
                BooksTable.Columns.NAME,
                BooksTable.Columns.AUTHOR,
                BooksTable.Columns.SHELF);

        db.execSQL(sqlText);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
