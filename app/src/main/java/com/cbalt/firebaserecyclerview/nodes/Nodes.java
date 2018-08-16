package com.cbalt.firebaserecyclerview.nodes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes {

    private DatabaseReference root =  FirebaseDatabase.getInstance().getReference();

    public DatabaseReference movies() {
        return root.child("movies");
    }

    public DatabaseReference albums() {
        return root.child("albums");
    }

}
