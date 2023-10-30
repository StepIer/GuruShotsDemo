package com.example.gurushotsdemo.data.api

import com.example.gurushotsdemo.data.api.model.GetPhotosPublicResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GuruShotsApi {

    @FormUrlEncoded
    @POST("get_photos_public")
    suspend fun getPhotos(
        @Field("member_id") memberId: String,
        @Field("start") start: Int,
        @Field("limit") limit: Int,
    ): GetPhotosPublicResponse
}