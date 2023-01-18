package com.example.posts

class AttachmentAudio : Attachment {
    override val type: String = "audio"
    val audio: Audio = Audio()
}

data class Audio(
    val id: Int = 1,
    val ownerId: Int = 2,
    val artist: String = "Suzanna",
    val title: String = "Iriy"
)