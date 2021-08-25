package ru.androidschool.sqliteexample.data.db;

import android.provider.BaseColumns;

public class BooksTable {

    public static final String NAME = "books";

    public static class Columns implements BaseColumns {
        public static final String UUID   = "uuid";
        public static final String NAME   = "NAME";
        public static final String AUTHOR = "author";
        public static final String SHELF  = "shelf";
        public static final String COUNT  = "count";
    }
}
