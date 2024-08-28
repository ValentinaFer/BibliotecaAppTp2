package com.softulp.biblioteca;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.biblioteca.models.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private List<Libro> books;
    private MutableLiveData<String> mToastMsg;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        books = new ArrayList<>();
        books.add(new Libro("The Lord of the Rings", "The Lord of the Rings is a novel set in the Third Age of Middle-earth, and is a sequel to Tolkien’s The Hobbit. The book is about a group of heroes who set forth to save their world from evil. The inhabitants of Middle Earth join together to save themselves from enslavement by the malevolent Sauron, who forged a Ring to control through a series of lesser rings, men, dwarves, and elves. The book is about power and greed, innocence and enlightenment, and ultimately describes a battle of good against evil.", "J.R.R. Tolkien", 1954, "High fantasy", 1182, R.drawable.tlotr));
        books.add(new Libro("The Black Cat", "The story's narrator is an animal lover who, as he descends into alcoholism and perverse violence, begins mistreating his wife. In a drunken rage, the narrator hangs his beloved black cat, Pluto. The story illustrates the capacity of the human mind to observe its own deterioration and the ability of the mind to comment upon its own destruction without being able to objectively halt that deterioration.", "Edgar Allan Poe",1843 ,"Classics, Horror, Short Stories, Fiction, Gothic, Mystery, School, 19th Century, American",24, R.drawable.blackcat));
        books.add(new Libro("The picture of Dorian Gray", "The Picture of Dorian Gray is a novel by Oscar Wilde that explores the themes of morality, beauty, and hedonism. The novel tells the story of Dorian Gray, a young man who has a portrait that ages instead of him. Influenced by Lord Henry Wotton, Dorian embraces a life of sin and pleasure without consequences. However, his portrait reflects his corruption and decay", "Oscar Wilde", 1890,"Classics, Fiction, Horror, Fantasy, Gothic, Literature, Novels, LGBT, 19th Century",224, R.drawable.doriangray));
        books.add(new Libro("The Raven", "The Raven by Edgar Allan Poe is a narrative poem. It tells the story of a bereaved lover who is visited by a mysterious raven late at night. The raven speaks a single word—\"nevermore\"—intensifying the man's grief over lost love. The poem explores themes of loss, beauty, and emotional battles.", "Edgar Allan Poe", 1845, "Gothic, Horror, Fiction, 19th century, American", 34, R.drawable.raven ));
    }

    public LiveData<String> getMtoastMsg(){
        if (mToastMsg == null){
        mToastMsg = new MutableLiveData<>();
        }
        return mToastMsg;
    }

    public void findLibro(String title){
        if (title.isEmpty()){
            mToastMsg.setValue("Debe ingresar el titulo de un libro!");
            return;
        }
        for (Libro l : books){
            if (l.getTitle().equalsIgnoreCase(title)){
                Intent intent = new Intent(getApplication(), DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book", l);
                intent.putExtra("book", bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
                return;
            }
        }
        mToastMsg.setValue("El libro no se encuentra...");
    }

}
