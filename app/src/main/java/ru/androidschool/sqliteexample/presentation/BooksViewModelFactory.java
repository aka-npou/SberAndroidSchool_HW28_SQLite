package ru.androidschool.sqliteexample.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import ru.androidschool.sqliteexample.data.converter.BookConverter;
import ru.androidschool.sqliteexample.data.db.BookDataBase;
import ru.androidschool.sqliteexample.data.repository.BooksRepositoryImpl;
import ru.androidschool.sqliteexample.domain.BooksInteractor;

class BooksViewModelFactory implements ViewModelProvider.Factory {

    private final BookDataBase mDataBase;

    public BooksViewModelFactory(Context context) {
        mDataBase = Room.databaseBuilder(context, BookDataBase.class, "books.db").build();
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(
                new BooksInteractor(
                        new BooksRepositoryImpl(
                        new BookConverter(), mDataBase.getBookDao())));
    }
}
