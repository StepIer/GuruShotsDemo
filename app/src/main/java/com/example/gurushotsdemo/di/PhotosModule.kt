package com.example.gurushotsdemo.di

import com.example.gurushotsdemo.data.Config
import com.example.gurushotsdemo.data.PhotosRepositoryImpl
import com.example.gurushotsdemo.data.api.GuruShotsApi
import com.example.gurushotsdemo.data.api.GuruShotsInterceptor
import com.example.gurushotsdemo.domain.GetPhotosUseCase
import com.example.gurushotsdemo.domain.PhotosRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object PhotosModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(GuruShotsInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideGuruShotsApiRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(Config.BASE_API_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideExchangeRatesApi(retrofit: Retrofit): GuruShotsApi {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun providePhotosRepository(
        api: GuruShotsApi
    ): PhotosRepository {
        return PhotosRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetPhotosUseCase(
        photosRepository: PhotosRepository
    ): GetPhotosUseCase {
        return GetPhotosUseCase(photosRepository)
    }
}