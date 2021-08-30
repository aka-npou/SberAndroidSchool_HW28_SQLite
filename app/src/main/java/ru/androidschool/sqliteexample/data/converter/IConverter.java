package ru.androidschool.sqliteexample.data.converter;

import androidx.annotation.NonNull;

public interface IConverter<T, R> {

    @NonNull
    R convert(@NonNull T item);

    @NonNull
    T reverse(@NonNull R item);

}
