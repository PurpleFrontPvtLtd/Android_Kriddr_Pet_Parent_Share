package com.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.Model.NotesModel;

import java.util.ArrayList;
import java.util.List;

import kriddrpetparent.com.kriddr.R;

/**
 * Created by pf-05 on 2/22/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    List<NotesModel> notesList = new ArrayList<>();
    Context context;


    public NotesAdapter(List<NotesModel> notesList, Context context)
    {
        this.notesList = notesList;
        this.context = context;


    }


    @Override
    public NotesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lo_row_notes,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.MyViewHolder holder, int position) {


        if(!notesList.get(position).getCreated().equalsIgnoreCase("Empty") && !notesList.get(position).getNotes().equalsIgnoreCase("Empty"))
        {
            holder.notes_date.setText(notesList.get(position).getCreated());
            holder.notes_desc.setText(notesList.get(position).getNotes());
        }


    }

    @Override
    public int getItemCount() {

        if(notesList.size() < 3)
        {
            return notesList.size();
        }
        else
        {
            return 3;
        }


    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView notes_date, notes_desc;


        public MyViewHolder(View itemView) {
            super(itemView);

           notes_date = (TextView) itemView.findViewById(R.id.notes_date);
            notes_desc = (TextView)itemView.findViewById(R.id.notes_des);

        }
    }
}
