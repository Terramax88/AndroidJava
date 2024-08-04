package com.terra.note;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDAO {
@Insert
 void add(Note note);
@Delete
 void delete(Note note);
@Query("SELECT * FROM notes_table")
 LiveData<List<Note>> allNotes();
}
