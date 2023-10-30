package com.example.gurushotsdemo.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPhotosUseCase(
    private val photosRepository: PhotosRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun invoke(currentLastPhoto: Int): Result<List<String>> =
        withContext(dispatcher) {
            return@withContext photosRepository.getPhotos(currentLastPhoto)
        }
}