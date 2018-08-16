package com.cbalt.firebaserecyclerview.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.cbalt.firebaserecyclerview.R;
import com.cbalt.firebaserecyclerview.adapters.AlbumsAdapter;
import com.cbalt.firebaserecyclerview.interfaces.AlbumListener;
import com.cbalt.firebaserecyclerview.models.Album;
import com.cbalt.firebaserecyclerview.nodes.Nodes;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class AlbumListActivity extends AppCompatActivity implements AlbumListener {

    public static final String ALBUM = "com.cbalt.firebaserecyclerview";
    private ProgressDialog progressDialog;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        //progressBar = new ProgressBar(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.show();


        setRecyclerView();



        //setNodeChildListener();

    }


    private void setRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.albumRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Divider
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        //dividerItemDecoration.setDrawable(/*ID DEL DRAWABLE*/);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<Album> options = new FirebaseRecyclerOptions.Builder<Album>()
                .setQuery(new Nodes().albums(), Album.class)
                .setLifecycleOwner(this)
                .build();

        AlbumsAdapter albumsAdapter = new AlbumsAdapter(options, this);
        recyclerView.setAdapter(albumsAdapter);
    }


    private void setNodeChildListener(){
        new Nodes().albums().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Album album = dataSnapshot.getValue(Album.class);
                Log.d("ALBUM", album.getName());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void click(Album album) {
        Intent intent = new Intent(this, AlbumActivity.class);
        intent.putExtra(ALBUM, album);
        startActivity(intent);
    }

    @Override
    public void dataChanged() {
        progressDialog.dismiss();
    }
}
