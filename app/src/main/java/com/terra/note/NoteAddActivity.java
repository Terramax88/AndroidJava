package com.terra.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.terra.note.databinding.ActivityNoteAddBinding;

public class NoteAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        ActivityNoteAddBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_note_add);
        Note note = new Note();
        binding.setNote(note);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.setNoteHandler(new NoteHandler(this, note, myViewModel));
    }
}