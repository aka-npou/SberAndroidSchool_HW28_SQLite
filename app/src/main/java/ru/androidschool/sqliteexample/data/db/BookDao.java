package ru.androidschool.sqliteexample.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.androidschool.sqliteexample.data.entity.BookEntity;

@Dao
public interface BookDao {

    @Insert
    void addBooks(List<BookEntity> entity);

    @Query("SELECT * FROM books")
    List<BookEntity> books();
}
