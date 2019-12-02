package com.example.labor8planningpokeruser;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private  String voteTo;
    private  String key;
    private ArrayList<Votes> votes;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private TextView titleTextView;
    private Users user;

    public ListFragment(String key, String voteTo, Users user) {
        this.key = key;
        this.voteTo = voteTo;
        this.user = user;
        votes = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.list_fragment, container, false);
        titleTextView = view.findViewById(R.id.titleTextView);
        titleTextView.setText(voteTo);
        recyclerView = view.findViewById(R.id.votesRecyclerView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new VotesListAdapter(getContext(),votes);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        reference.child("votes").child(key).child(voteTo).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                votes.clear();
                for (DataSnapshot voteSnapshot : dataSnapshot.getChildren()){
                    Votes vote = voteSnapshot.getValue(Votes.class);
                    votes.add(vote);
                }
                mAdapter = new VotesListAdapter(getContext(),votes);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
