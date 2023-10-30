package com.example.gurushotsdemo.data

import com.example.gurushotsdemo.data.api.GuruShotsApi
import com.example.gurushotsdemo.domain.PhotosRepository

class PhotosRepositoryImpl(
    private val api: GuruShotsApi
) : PhotosRepository {

    override suspend fun getPhotos(currentLastPhoto: Int): Result<List<String>> {
        return try {
            val response = api.getPhotos(
                memberId = GET_PHOTOS_MEMBER_ID,
                start = currentLastPhoto,
                limit = GET_PHOTOS_LIMIT
            )
            Result.success(response.items.map { photoItem -> photoItem.id })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    companion object {
        private const val GET_PHOTOS_MEMBER_ID = "2a49ab04b1534574e578a08b8f9d7441"
        private const val GET_PHOTOS_LIMIT = 50
    }
}