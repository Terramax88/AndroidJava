package com.terra.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.terra.note.databinding.NoteItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

   private ArrayList<Note> notes;

   public MyAdapter(ArrayList<Note> notes) {
      this.notes = notes;
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
      holder.noteItemBinding.setNote(note);
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
