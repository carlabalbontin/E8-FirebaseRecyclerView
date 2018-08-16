package com.cbalt.firebaserecyclerview.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cbalt.firebaserecyclerview.R;

public class MainActivity extends AppCompatActivity {

    Button movieList, albumList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = findViewById(R.id.movieListButton);
        albumList = findViewById(R.id.albumListButton);

        movieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MovieListActivity.class);
                startActivity(intent);
            }
        });

        albumList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlbumListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToList(Activity ListActivity){

    }
}
