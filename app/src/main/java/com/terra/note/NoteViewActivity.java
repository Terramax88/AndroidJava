package com.terra.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.terra.note.databinding.ActivityNoteAddBinding;
import com.terra.note.databinding.ActivityNoteViewBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNoteViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_note_view);

        int position = getIntent().getIntExtra("position", 0);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        LiveData<List<Note>> liveData = myViewModel.getNotes();
        liveData.observe(
                this,
                new Observer<List<Note>>() {
                    @Override
                    public void onChanged(List<Note> notes) {
                        Note note = notes.get(position);
                        binding.textNoteId.setText("id: "+note.getId());
                        binding.textNoteTitle.setText("title: " + note.getTitle());
                        binding.textNoteText.setText(note.getNote());
                    }
                }
        );

        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoteViewActivity.this, MainActivity.class));
            }
        });
    }

}