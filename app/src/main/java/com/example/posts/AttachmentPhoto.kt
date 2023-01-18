package com.example.posts

class AttachmentPhoto : Attachment {
    override val type: String = "photo"
    val photo: Photo = Photo()
}

data class Photo(
    val id: Long = 1,
    val albumId: Long = 2,
    val ownerId: Long = 2,
    val text: String = "Мы"
)