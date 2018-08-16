package com.cbalt.firebaserecyclerview.interfaces;

import com.cbalt.firebaserecyclerview.models.Album;

public interface AlbumListener {

    void click(Album album);
    void dataChanged();
}
