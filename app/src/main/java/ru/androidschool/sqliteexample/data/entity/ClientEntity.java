package ru.androidschool.sqliteexample.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clients")
public class ClientEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String uuid;
    public String name;
}
