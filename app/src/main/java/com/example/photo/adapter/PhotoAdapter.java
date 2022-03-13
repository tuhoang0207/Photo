package com.example.photo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.photo.R;
import com.example.photo.models.Photo;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    ArrayList<Photo> photos;
    public PhotoAdapter(ArrayList<Photo> photos) {
        this.photos = photos;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.photo_list_item, viewGroup, false);
        //Activity + Service
        Photo photo = photos.get(i);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewTitle.setText(photo.getTitle());
        //cac field khac ??
        return view;
    }

}
