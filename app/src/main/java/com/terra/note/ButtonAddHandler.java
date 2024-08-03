package com.terra.note;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class ButtonAddHandler {
   Context context;

   public ButtonAddHandler(Context context) {
      this.context = context;
   }

   public void AddNote(View view){
      Intent intent = new Intent(context, NoteAddActivity.class);
      context.startActivity(intent);
   }
}
