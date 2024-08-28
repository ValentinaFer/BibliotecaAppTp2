package com.softulp.biblioteca;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.biblioteca.models.Libro;

public class DetailsActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Libro> mBook;

    public DetailsActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getMBook(){
        if (mBook == null){
            mBook = new MutableLiveData<>();
        }
        return mBook;
    }

    public void showBook(Intent intent){
        Bundle bundle = intent.getBundleExtra("book");
        Libro book = (Libro) bundle.getSerializable("book");

        if (book != null) {
            mBook.setValue(book);
        }

    }

}
