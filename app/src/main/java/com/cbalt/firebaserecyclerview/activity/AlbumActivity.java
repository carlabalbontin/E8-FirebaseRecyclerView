package com.cbalt.firebaserecyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cbalt.firebaserecyclerview.R;
import com.cbalt.firebaserecyclerview.models.Album;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Album album = (Album) getIntent().getSerializableExtra(AlbumListActivity.ALBUM);
        getSupportActionBar().setTitle(album.getName());
    }
}
