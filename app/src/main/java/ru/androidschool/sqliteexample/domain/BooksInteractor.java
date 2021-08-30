package ru.androidschool.sqliteexample.domain;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksInteractor {

    private final BooksRepository mRepository;

    public BooksInteractor(BooksRepository repository) {
        mRepository = repository;
    }

    public List<Book> getBooks() {
        Log.i("TAG", "getBooks: ");
        mRepository.initRepository(Arrays.asList(
                new Book(1, "1", "t1", "a1", 1),
                new Book(2, "2", "t2", "a1", 1),
                new Book(3, "3", "t3", "a2", 1)
        ));

        return mRepository.books();
    }
}
