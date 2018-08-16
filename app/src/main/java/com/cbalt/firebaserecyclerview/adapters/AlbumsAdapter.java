package com.cbalt.firebaserecyclerview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbalt.firebaserecyclerview.R;
import com.cbalt.firebaserecyclerview.interfaces.AlbumListener;
import com.cbalt.firebaserecyclerview.models.Album;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AlbumsAdapter extends FirebaseRecyclerAdapter<Album, AlbumsAdapter.AlbumHolder> {

    private AlbumListener listener;
    private boolean first = true;


    public AlbumsAdapter(@NonNull FirebaseRecyclerOptions<Album> options, AlbumListener listener) {
        super(options);
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_album, parent, false);
        return new AlbumHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final AlbumHolder holder, int position, @NonNull Album model) {
        holder.albumName.setText(model.getName());
        holder.albumBand.setText(model.getBand());
        holder.albumGender.setText(model.getGender());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Album auxAlbum = getItem(holder.getAdapterPosition());
                listener.click(auxAlbum);
            }
        });
    }

    @Override
    public void onDataChanged() {
        if(first){
            // la primera vez que cambia la data. ie:cuando la trae por primera vez
            first = false;
            listener.dataChanged();
        }
    }

    public static class AlbumHolder extends RecyclerView.ViewHolder {
        private TextView albumName, albumBand, albumGender;

        public AlbumHolder(View itemView) {
            super(itemView);

            albumName = itemView.findViewById(R.id.albumNameTv);
            albumBand = itemView.findViewById(R.id.albumBandTv);
            albumGender = itemView.findViewById(R.id.albumGenderTv);
        }
    }
}
