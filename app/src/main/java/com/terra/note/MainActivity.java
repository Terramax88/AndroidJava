package com.terra.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.terra.note.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> noteArrayList = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test uchun
//        noteArrayList.add(new Note(1, "Note1 Title", "writings notes in note1"));

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        myViewModel.getNotes().observe(
                this,
                new Observer<List<Note>>() {
                    @Override
                    public void onChanged(List<Note> notes) {
                        noteArrayList.clear();
                        for(Note note : notes){
                            noteArrayList.add(note);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        Log.v("Main A", "" + noteArrayList.size());

        adapter = new MyAdapter(noteArrayList, myViewModel, this);
        recyclerView.setAdapter(adapter);



        FloatingActionButton btn = binding.floatingActionButton;
        binding.setAddButtonHandler(new ButtonAddHandler(this));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Note note = noteArrayList.get(viewHolder.getAdapterPosition());
                myViewModel.delete(note);
            }
        }).attachToRecyclerView(recyclerView);




    }
}