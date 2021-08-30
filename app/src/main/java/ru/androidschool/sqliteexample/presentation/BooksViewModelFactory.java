package ru.androidschool.sqliteexample.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import ru.androidschool.sqliteexample.data.converter.BookConverter;
import ru.androidschool.sqliteexample.data.converter.ClientConverter;
import ru.androidschool.sqliteexample.data.db.AppDataBase;
import ru.androidschool.sqliteexample.data.repository.BooksRepositoryImpl;
import ru.androidschool.sqliteexample.data.repository.ClientRepositoryImpl;
import ru.androidschool.sqliteexample.domain.BooksInteractor;
import ru.androidschool.sqliteexample.domain.ClientInteractor;

class BooksViewModelFactory implements ViewModelProvider.Factory {

    private final AppDataBase mAppDataBase;

    public BooksViewModelFactory(Context context) {
        mAppDataBase = Room.databaseBuilder(context, AppDataBase.class, "appDB.db").fallbackToDestructiveMigration().build();
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(
                new BooksInteractor(
                        new BooksRepositoryImpl(
                        new BookConverter(), mAppDataBase.getBookDao())),
                new ClientInteractor(
                        new ClientRepositoryImpl(
                        new ClientConverter(), mAppDataBase.getClientDao()))
        );
    }
}
