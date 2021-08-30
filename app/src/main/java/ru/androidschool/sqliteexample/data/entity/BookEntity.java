package ru.androidschool.sqliteexample.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class BookEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String uuid;
    public String title;
    public String author;
    public int shelfNumber;
}
