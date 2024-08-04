package com.terra.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
   private Repository repository;
   private LiveData<List<Note>> notes;

   public MyViewModel(@NonNull Application application) {
      super(application);
      this.repository = new Repository(application);
   }

   public void add(Note note){
      repository.add(note);
   }

   public void delete(Note note){
      repository.delete(note);
   }

   public LiveData<List<Note>> getNotes(){
      notes = repository.getNotes();
      return notes;
   }
}
