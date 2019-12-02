package com.example.labor8planningpokeruser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VotesAdapter extends RecyclerView.Adapter<VotesAdapter.ViewHolder>{
    private Context context;
    private ArrayList<String> items;
    private Integer voteNumber;
    private  boolean check = true;

    public VotesAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
        this.voteNumber = -1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.textView.setBackgroundResource(R.drawable.item_background);
        holder.textView.setText(items.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == true) {
                    check = false;
                    voteNumber = position;
                    //Toast.makeText(context, "Card is clicked " + position, Toast.LENGTH_SHORT).show();
                    holder.textView.setBackgroundResource(R.drawable.item_background_change);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public int getVoteNumber() {
        switch(this.voteNumber){
            case 0:{
                return 1;
            }
            case 1:{
                return 3;
            }
            case 2:{
                return 5;
            }
            case 3:{
                return 7;
            }
            case 4:{
                return 10;
            }
            case 5:{
                return 20;
            }
            case 6:{
                return 50;
            }
            case 7:{
                return 100;
            }
            case 8:{
                return -2;
            }
        }

        return -1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView textView;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.cardImageButton);
            parentLayout = itemView.findViewById(R.id.parentLayout);

        }
    }
}
