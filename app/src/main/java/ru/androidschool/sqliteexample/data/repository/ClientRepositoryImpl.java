package ru.androidschool.sqliteexample.data.repository;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.sqliteexample.data.converter.IConverter;
import ru.androidschool.sqliteexample.data.db.ClientDao;
import ru.androidschool.sqliteexample.data.entity.ClientEntity;
import ru.androidschool.sqliteexample.domain.ClientRepository;
import ru.androidschool.sqliteexample.domain.model.Client;

public class ClientRepositoryImpl implements ClientRepository {

    @NonNull
    private final IConverter<Client, ClientEntity> converter;
    @NonNull
    private final ClientDao clientDao;

    public ClientRepositoryImpl(@NonNull IConverter<Client, ClientEntity> converter,
                                @NonNull ClientDao clientDao) {
        this.converter = converter;
        this.clientDao = clientDao;
    }

    @Override
    public void initRepository(List<Client> clients) {
        List<ClientEntity> clientEntityList = new ArrayList<>();

        for (Client client:clients) {
            clientEntityList.add(converter.convert(client));
        }

        clientDao.addClients(clientEntityList);
    }

    @Override
    public List<Client> clients() {
        List<ClientEntity> clientEntityList = clientDao.clients();
        List<Client> clients = new ArrayList<>();

        for (ClientEntity entity:clientEntityList) {
            clients.add(converter.reverse(entity));
        }
        return clients;
    }
}
