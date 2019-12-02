package com.example.labor8planningpokeruser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VotesListAdapter extends RecyclerView.Adapter<VotesListAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Votes> data;

    public VotesListAdapter(Context context, ArrayList<Votes> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VotesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.votes_recyclerview_item, parent, false);
        ViewHolder viewHolder = new VotesListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VotesListAdapter.ViewHolder holder, int position) {
        holder.name.setText("User Name: "+data.get(position).userName);
        holder.id.setText("User Id: "+data.get(position).userId);
        holder.mark.setText("Card: "+data.get(position).mark);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;
        TextView mark;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userNameTextView);
            id = itemView.findViewById(R.id.userIdTextView);
            mark = itemView.findViewById(R.id.markTextView);
        }
    }
}
