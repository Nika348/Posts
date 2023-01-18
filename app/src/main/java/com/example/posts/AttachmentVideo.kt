package com.example.posts

class AttachmentVideo : Attachment {
    override val type: String = "video"
    val video: Video = Video()
}

data class Video(
    val id: Long = 1,
    val ownerId: Long = 1,
    val artist: String = "Suzanna",
    val description: String = "clip",
)