package ru.androidschool.sqliteexample.data.converter;

import androidx.annotation.NonNull;

import ru.androidschool.sqliteexample.data.entity.BookEntity;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BookConverter implements IConverter<Book, BookEntity> {
    @NonNull
    @Override
    public BookEntity convert(@NonNull Book item) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.author = item.author;
        bookEntity.title = item.title;
        bookEntity.uuid = item.uuid;
        bookEntity.shelfNumber = item.shelfNumber;
        return bookEntity;
    }

    @NonNull
    @Override
    public Book reverse(@NonNull BookEntity item) {
        return new Book(item.id, item.uuid, item.title, item.author, item.shelfNumber);
    }
}
