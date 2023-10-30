package com.example.gurushotsdemo.presentation

import com.example.gurushotsdemo.data.Config

fun getPhotoLink(photoId: String): String {
    return "${Config.BASE_PHOTOS_URL}${Config.MEMBER_ID}/3_$photoId.jpg"
}