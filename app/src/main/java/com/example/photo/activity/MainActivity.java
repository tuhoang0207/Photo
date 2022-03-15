package com.example.photo.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.photo.R;
import com.example.photo.adapter.PhotoAdapter;
import com.example.photo.models.Photo;
import com.example.photo.service.IPhotoServicesResponse;
import com.example.photo.service.PhotoService;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    //UI
    private ListView listViewPhotos;
    //Data & services
    private ArrayList<Photo> photos = new ArrayList<Photo>();
    private PhotoService photoService = new PhotoService();
    private PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPhotos = findViewById(R.id.listViewPhotos);
        photoAdapter = photoAdapter ==  null ? new PhotoAdapter(photos) : photoAdapter;
        listViewPhotos.setAdapter(photoAdapter);

        photoService.getPhoto(new IPhotoServicesResponse() {

            @Override
            public void getPhotos(ArrayList<Photo> photos,String error) {
                MainActivity.this.photos = photos;
                //Android SDK
                //MainActivity.this.photos = photos.stream().limit(10).collect(Collectors.toList());
                runOnUiThread(new Runnable() {
                    public void run() {
                        //clear/reload data
                        photoAdapter.getPhotos().clear();
                        photoAdapter.getPhotos().addAll(photos);
                        //dirty code
//                        for(int i = 0; i < 10; i++) {
//                            photoAdapter.getPhotos().add(photos.get(i));
//                        }
                        //single adapter/single data
                        photoAdapter.notifyDataSetChanged();
                        listViewPhotos.invalidate();//reload listview
                    }
                });
            }
        });

    }
}