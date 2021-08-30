package ru.androidschool.sqliteexample.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.sqliteexample.data.converter.IConverter;
import ru.androidschool.sqliteexample.data.db.BookDao;
import ru.androidschool.sqliteexample.data.entity.BookEntity;
import ru.androidschool.sqliteexample.domain.BooksRepository;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksRepositoryImpl implements BooksRepository {

    @NonNull
    private final IConverter<Book, BookEntity> converter;
    @NonNull
    private final BookDao bookDao;

    public BooksRepositoryImpl(@NonNull IConverter<Book, BookEntity> converter,
                               @NonNull BookDao bookDao) {
        this.converter = converter;
        this.bookDao = bookDao;
    }

    @Override
    public void initRepository(List<Book> books) {
        List<BookEntity> bookEntityList = new ArrayList<>();

        for (Book book:books) {
            bookEntityList.add(converter.convert(book));
        }

        Log.i("TAG", "initRepository: " + bookEntityList.size());
        bookDao.addBooks(bookEntityList);
    }

    @Override
    public List<Book> books() {
        List<BookEntity> bookEntityList = bookDao.books();
        Log.i("TAG", "books: " + bookEntityList.size());
        List<Book> books = new ArrayList<>();

        for (BookEntity entity:bookEntityList) {
            books.add(converter.reverse(entity));
        }
        return books;
    }
}
