package ru.androidschool.sqliteexample.data.converter;

import androidx.annotation.NonNull;

import ru.androidschool.sqliteexample.data.entity.ClientEntity;
import ru.androidschool.sqliteexample.domain.model.Client;

public class ClientConverter implements IConverter<Client, ClientEntity> {
    @NonNull
    @Override
    public ClientEntity convert(@NonNull Client item) {
        ClientEntity clientEntity = new ClientEntity();

        clientEntity.id = item.id;
        clientEntity.name = item.name;
        clientEntity.uuid = item.uuid;

        return clientEntity;
    }

    @NonNull
    @Override
    public Client reverse(@NonNull ClientEntity item) {
        return new Client(item.id, item.name, item.uuid);
    }
}
