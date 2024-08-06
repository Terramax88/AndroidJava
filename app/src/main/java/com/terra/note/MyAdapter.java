package com.terra.note;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.terra.note.databinding.NoteItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

   private ArrayList<Note> notes;
   MyViewModel myViewModel;

   Context context;

   public MyAdapter(ArrayList<Note> notes, MyViewModel myViewModel, Context context) {
      this.notes = notes;
      this.myViewModel = myViewModel;
      this.context = context;
      Log.v("BBB", ""+notes.size());
   }

   public MyAdapter() {
   }

   @NonNull
   @Override
   public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      NoteItemBinding noteItemBinding = DataBindingUtil.inflate(
              LayoutInflater.from(parent.getContext()),
              R.layout.note_item,
              parent,
              false
      );

      return new MyHolder(noteItemBinding);
   }

   @Override
   public void onBindViewHolder(@NonNull MyHolder holder, int position) {
      Note note = notes.get(position);
      Log.v("BBB OnBind", "" + notes.get(position).getId());
      holder.noteItemBinding.setNote(note);

      CardView cardView = holder.noteItemBinding.cardView;
      cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(context, NoteViewActivity.class);
            intent.putExtra("position", holder.getAdapterPosition());
            context.startActivity(intent);
         }
      });
   }

   @Override
   public int getItemCount() {
      if(notes == null){
         return 0;
      } else {
         return notes.size();
      }
   }

   class MyHolder extends RecyclerView.ViewHolder{
      NoteItemBinding noteItemBinding;

      public MyHolder(NoteItemBinding noteItemBinding) {
         super(noteItemBinding.getRoot());
         this.noteItemBinding = noteItemBinding;
      }
   }
}
