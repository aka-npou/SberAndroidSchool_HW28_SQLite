package ru.androidschool.sqliteexample.data.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import ru.androidschool.sqliteexample.data.db.BookDbHelper;
import ru.androidschool.sqliteexample.data.db.BooksTable;
import ru.androidschool.sqliteexample.domain.BooksRepository;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksRepositoryImpl implements BooksRepository {

    private static final String TAG = BooksRepositoryImpl.class.getSimpleName();
    private final BookDbHelper mHelper;

    public BooksRepositoryImpl(BookDbHelper helper) {
        mHelper = helper;
    }

    @Override
    public void initRepository() {
        SQLiteDatabase database = mHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BooksTable.Columns.UUID, "123456789012");
        values.put(BooksTable.Columns.NAME, "синяя книга");
        values.put(BooksTable.Columns.AUTHOR, "известный");
        values.put(BooksTable.Columns.SHELF, "777");
        values.put(BooksTable.Columns.COUNT, "1");

        long id = database.insert(BooksTable.NAME, null, values);

        if (id == -1) {
            Log.e(TAG, "Insert fail");
        }
    }

    @Override
    public List<Book> books() {
        SQLiteDatabase database = mHelper.getReadableDatabase();

        String[] columns = {
                BooksTable.Columns._ID,
                BooksTable.Columns.UUID,
                BooksTable.Columns.NAME,
                BooksTable.Columns.AUTHOR,
                BooksTable.Columns.SHELF,
                BooksTable.Columns.COUNT
        };

        List<Book> books = new LinkedList<>();

        try (Cursor cursor = database.query(
                BooksTable.NAME, columns, null, null, null, null, null)){
            while (cursor.moveToNext()) {
                books.add(new Book(
                        cursor.getLong(cursor.getColumnIndexOrThrow(BooksTable.Columns._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BooksTable.Columns.UUID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BooksTable.Columns.NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BooksTable.Columns.AUTHOR)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BooksTable.Columns.SHELF)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BooksTable.Columns.COUNT))));
            }
        }
        return books;
    }
}
