package com.cbalt.firebaserecyclerview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbalt.firebaserecyclerview.R;
import com.cbalt.firebaserecyclerview.models.Movie;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MovieAdapter extends FirebaseRecyclerAdapter<Movie, MovieAdapter.MovieHolder> {


    public MovieAdapter(@NonNull FirebaseRecyclerOptions<Movie> options) {
        super(options);
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MovieHolder holder, int position, @NonNull Movie movie) {
        holder.movieNameTv.setText(movie.getName());
        holder.movieScoreTv.setText(movie.getScore());
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        private TextView movieNameTv, movieScoreTv;

        public MovieHolder(View itemView) {
            super(itemView);
            movieNameTv = itemView.findViewById(R.id.movieNameTv);
            movieScoreTv = itemView.findViewById(R.id.movieScoreTv);
        }
    }
}
