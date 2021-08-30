package ru.androidschool.sqliteexample.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.androidschool.sqliteexample.data.entity.BookEntity;

@Database(
        entities = BookEntity.class,
        version = 1
)
public abstract class BookDataBase extends RoomDatabase {
    public abstract BookDao getBookDao();
}
