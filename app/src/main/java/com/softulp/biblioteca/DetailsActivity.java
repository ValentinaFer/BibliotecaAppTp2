package com.softulp.biblioteca;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.biblioteca.databinding.ActivityDetailsBinding;
import com.softulp.biblioteca.models.Libro;

public class DetailsActivity extends AppCompatActivity {

    private DetailsActivityViewModel vm;
    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetailsActivityViewModel.class);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        vm.getMBook().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.tvTitle.setText(libro.getTitle());
                binding.tvSummary.setText(libro.getSummary());
                binding.imageView.setImageResource(libro.getCover());
                binding.tvDetails.setText("Author: "+libro.getAuthors()+".\nAge of release: "+libro.getAgeRelease()+".\nPages: "+libro.getPages()+".\nGenres: "+libro.getGenres());
            }
        });

        vm.showBook(getIntent());

    }
}