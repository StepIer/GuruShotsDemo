package com.example.gurushotsdemo.data

object Config {
    const val BASE_API_URL = "https://api.gurushots.com/rest/"
    const val BASE_PHOTOS_URL = "https://photos.gurushots.com/unsafe/"
    const val MEMBER_ID = "2a49ab04b1534574e578a08b8f9d7441"

    val MAP_HEADERS: MutableMap<String, String> = mutableMapOf(
        "X-API-VERSION" to "13",
        "X-ENV" to "WEB",
        "X-TOKEN" to "539a5789c36b7d3408a0aa1df73dc46d976fadaa9b85b60c9eb8c864a2803b20400b406a810cf83d2699b0d372f75d78",
        "X-Requested-With" to "XMLHttpRequest",
        "X-APP-VERSION" to "5.18.11"
    )
}