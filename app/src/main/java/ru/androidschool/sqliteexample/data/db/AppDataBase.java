package ru.androidschool.sqliteexample.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.androidschool.sqliteexample.data.entity.BookEntity;
import ru.androidschool.sqliteexample.data.entity.ClientEntity;

@Database(
        entities = {BookEntity.class, ClientEntity.class},
        version = 1
)
public abstract class AppDataBase extends RoomDatabase {
    public abstract BookDao getBookDao();
    public abstract ClientDao getClientDao();
}
