package ru.androidschool.sqliteexample.domain.model;

public class Client {
    public long id;
    public String uuid;
    public String name;

    public Client(long id, String name, String uuid) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
    }
}
