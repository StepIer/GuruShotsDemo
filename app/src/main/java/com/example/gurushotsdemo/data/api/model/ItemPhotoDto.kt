package com.example.gurushotsdemo.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemPhotoDto(
    @SerialName("id") val id: String,
    @SerialName("ratio") val ratio: Float,
    @SerialName("member_id") val memberId: String,
    @SerialName("title") val title: String,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("views") val views: Int,
    @SerialName("adult") val isAdult: Boolean,
    @SerialName("upload_date") val uploadDate: Long,
    @SerialName("labels") val labels: List<String>,
    @SerialName("event_id") val eventId: Long
)
