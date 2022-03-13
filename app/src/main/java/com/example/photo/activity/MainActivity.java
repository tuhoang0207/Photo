package com.example.photo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.photo.R;
import com.example.photo.adapter.PhotoAdapter;
import com.example.photo.models.Photo;
import com.example.photo.service.IPhotoServicesResponse;
import com.example.photo.service.photoService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Photo> photos = new ArrayList<Photo>();
    private photoService photoService = new photoService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewPhotos);
        photoService.getPhoto(new IPhotoServicesResponse() {
            @Override
            public void getPhotos(ArrayList<Photo> photos,String error) {

            }
        });
        listView.setAdapter(new PhotoAdapter(photos));
    }
}