package ru.androidschool.sqliteexample.domain;

import java.util.List;

import ru.androidschool.sqliteexample.domain.model.Client;

public interface ClientRepository {

    void initRepository(List<Client> clients);

    List<Client> clients();

}
