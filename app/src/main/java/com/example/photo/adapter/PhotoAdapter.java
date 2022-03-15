package com.example.photo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.photo.R;
import com.example.photo.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    private ArrayList<Photo> photos;
    public PhotoAdapter(ArrayList<Photo> photos) {
        this.photos = photos;
    }


    @Override
    public int getCount() {
        return this.photos.size();
    }

    @Override
    public Object getItem(int i) {
        return this.photos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.photos.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.photo_list_item, viewGroup, false);
        //Activity + Service
        Photo photo = photos.get(i);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewAlumId = view.findViewById(R.id.textViewAlumId);
        ImageView imageViewPerson = view.findViewById(R.id.imageViewPerson);

        textViewTitle.setText(photo.getTitle());
        textViewAlumId.setText(String.format("Albumid: %s", photo.getAlbumId()));
        String xxx= photo.getUrl();
        //Picasso.with(viewGroup.getContext()).load(photo.getUrl()).into(imageViewPerson);
        Picasso.get()
                .load(photo.getUrl())
                .resize(60, 60)
                .into(imageViewPerson);
        //cac field khac ??
        return view;
    }
    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }


}
