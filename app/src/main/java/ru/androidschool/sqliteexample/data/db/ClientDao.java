package ru.androidschool.sqliteexample.data.db;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.androidschool.sqliteexample.data.entity.ClientEntity;

@Dao
public interface ClientDao {

    @Insert(onConflict = IGNORE)
    void addClients(List<ClientEntity> entities);

    @Query("SELECT * FROM clients")
    List<ClientEntity> clients();
}
