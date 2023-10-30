package com.example.gurushotsdemo.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPhotosPublicResponse(
    @SerialName("items") val items: List<ItemPhotoDto>,
    @SerialName("success") val isSuccess: Boolean
)