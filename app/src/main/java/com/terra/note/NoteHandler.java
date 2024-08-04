package com.terra.note;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class NoteHandler {
   private Note note;
   private Context context;
   private MyViewModel myViewModel;

   public NoteHandler(Context context ,Note note, MyViewModel myViewModel) {
      this.note = note;
      this.context = context;
      this.myViewModel = myViewModel;
   }

   public void addNote(View view){
      if(note.getTitle() == null || note.getNote() == null){
         Toast.makeText(context, "Add Somthing", Toast.LENGTH_SHORT).show();
      }else{
         myViewModel.add(note);
         Intent intent = new Intent(context, MainActivity.class);
         context.startActivity(intent);
      }
   }
}
