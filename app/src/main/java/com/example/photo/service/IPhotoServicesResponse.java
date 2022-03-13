package com.example.photo.service;

import com.example.photo.models.Photo;

import java.util.ArrayList;

public interface IPhotoServicesResponse {
    public void getPhotos(ArrayList<Photo> photos,String error);
}
