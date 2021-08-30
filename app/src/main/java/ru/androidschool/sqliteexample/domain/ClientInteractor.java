package ru.androidschool.sqliteexample.domain;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import ru.androidschool.sqliteexample.domain.model.Book;
import ru.androidschool.sqliteexample.domain.model.Client;

public class ClientInteractor {

    private final ClientRepository mRepository;

    public ClientInteractor(ClientRepository repository) {
        mRepository = repository;
    }

    public List<Client> getClients() {
        Log.i("TAG", "getClients: ");
        mRepository.initRepository(Arrays.asList(
                new Client(1, "c1", "0001"),
                new Client(2, "c2", "0002"),
                new Client(3, "c3", "0003")
        ));

        return mRepository.clients();
    }
}
