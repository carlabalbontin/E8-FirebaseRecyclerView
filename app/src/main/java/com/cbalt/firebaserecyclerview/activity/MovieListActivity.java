package com.cbalt.firebaserecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cbalt.firebaserecyclerview.R;
import com.cbalt.firebaserecyclerview.adapters.MovieAdapter;
import com.cbalt.firebaserecyclerview.models.Movie;
import com.cbalt.firebaserecyclerview.nodes.Nodes;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        RecyclerView recyclerView = findViewById(R.id.movieRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setHasFixedSize(true);  // puede que no funcione bien

        FirebaseRecyclerOptions<Movie> options = new FirebaseRecyclerOptions.Builder<Movie>()
                .setQuery(new Nodes().movies(), Movie.class)
                .setLifecycleOwner(this)
                .build();

        MovieAdapter movieAdapter = new MovieAdapter(options);
        recyclerView.setAdapter(movieAdapter);
    }
}
