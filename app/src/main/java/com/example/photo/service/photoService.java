package com.example.photo.service;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.photo.models.Photo;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class photoService {
    private static final String urlPhotos = "https://jsonplaceholder.typicode.com/photos";
    private OkHttpClient okHttpClient = new OkHttpClient();
    public void getPhoto(IPhotoServicesResponse PhotoServicesResponse) {
        okHttpClient.newCall(new Request.Builder().url(urlPhotos).build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        ArrayList<Photo> photos = new ArrayList<>();
                        try {
                            JSONArray responseArray = new JSONArray(response.body().string());
                            for(int i = 0;i < responseArray.length();i++) {
                                JSONObject jsonObject = responseArray.getJSONObject(i);
                                Photo photo = Photo.getFromJSONObject(jsonObject);
                                photos.add(photo);



                            }
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                        response.body().string();
                        PhotoServicesResponse.getPhotos(photos,"");
                    }
                });
        Log.d("ddd", "getPhoto: ");
    }
}
