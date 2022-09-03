package com.matrix87.activities

import com.google.gson.annotations.SerializedName

data class Comment(
    val postId: Int,
    val id: Int,
    @SerializedName("nsame")
    val userName: String,
    val email: String,
    val body: String
)
