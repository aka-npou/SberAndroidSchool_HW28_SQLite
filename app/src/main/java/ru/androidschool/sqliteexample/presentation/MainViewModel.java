package ru.androidschool.sqliteexample.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.androidschool.sqliteexample.domain.BooksInteractor;
import ru.androidschool.sqliteexample.domain.ClientInteractor;
import ru.androidschool.sqliteexample.domain.model.Book;
import ru.androidschool.sqliteexample.domain.model.Client;

public class MainViewModel extends ViewModel {

    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private final MutableLiveData<List<Book>> mBooksData = new MutableLiveData<>();
    private final MutableLiveData<List<Client>> mClientData = new MutableLiveData<>();
    private final BooksInteractor mBooksInteractor;
    private final ClientInteractor mClientInteractor;

    public MainViewModel(BooksInteractor interactor, ClientInteractor clientInteractor) {
        mBooksInteractor = interactor;
        mClientInteractor = clientInteractor;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mExecutor.shutdownNow();
    }

    public LiveData<List<Book>> getBooksData() {
        if (!mBooksData.hasObservers()) {
            initBooksData();
        }
        return mBooksData;
    }

    private void initBooksData() {
        mExecutor.submit(() -> {
            List<Book> books = mBooksInteractor.getBooks();
            mBooksData.postValue(books);
        });
    }

    public LiveData<List<Client>> getClientData() {
        if (!mClientData.hasObservers()) {
            initClientData();
        }
        return mClientData;
    }

    private void initClientData() {
        mExecutor.submit(() -> {
            List<Client> clients = mClientInteractor.getClients();
            mClientData.postValue(clients);
        });
    }
}
