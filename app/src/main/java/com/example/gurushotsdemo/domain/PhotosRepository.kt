package com.example.gurushotsdemo.domain

interface PhotosRepository {

    suspend fun getPhotos(currentLastPhoto: Int): Result<List<String>>
}