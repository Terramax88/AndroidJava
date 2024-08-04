package com.terra.note;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
   private final NoteDAO noteDAO;
   ExecutorService executorService;

   public Repository(Application application) {
      NoteDatabase db = NoteDatabase.getInstance(application);
      noteDAO = db.getNoteDAO();
      executorService = Executors.newSingleThreadScheduledExecutor();
   }

   public void add(Note note){
      executorService.execute(new Runnable() {
         @Override
         public void run() {
            noteDAO.add(note);
         }
      });
   }

   public void delete(Note note){
      executorService.execute(new Runnable() {
         @Override
         public void run() {
            noteDAO.delete(note);
         }
      });
   }

   public LiveData<List<Note>> getNotes(){
      return noteDAO.allNotes();
   }
}
