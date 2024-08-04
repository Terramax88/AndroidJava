package com.terra.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
   public abstract NoteDAO getNoteDAO();

    static NoteDatabase dbInstance;

   public static synchronized NoteDatabase getInstance(Context context){
      if(dbInstance == null){
         dbInstance = Room.databaseBuilder(
                 context,
                 NoteDatabase.class,
                 "notes_db"
         ).fallbackToDestructiveMigration().build();
      }
      return dbInstance;
   }
}
