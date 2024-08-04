package com.terra.note;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Note {
   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "note_id")
   private int id;
   @ColumnInfo(name = "note_title")
   private String title;
   @ColumnInfo(name = "note_text")
   private String note;

   public Note( String title, String note) {
      this.title = title;
      this.note = note;
   }

   public Note() {
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }
}
