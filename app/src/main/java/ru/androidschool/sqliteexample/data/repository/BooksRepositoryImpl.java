package ru.androidschool.sqliteexample.data.repository;

import java.util.Collections;
import java.util.List;

import ru.androidschool.sqliteexample.domain.BooksRepository;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksRepositoryImpl implements BooksRepository {

    public BooksRepositoryImpl() {
    }

    @Override
    public void initRepository() {
    }

    @Override
    public List<Book> books() {
        return Collections.emptyList();
    }
}
