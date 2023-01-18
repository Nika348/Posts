package com.example.posts

class AttachmentDocument : Attachment {
    override val type: String = "document"
    val document: Document = Document()
}

data class Document(
    val id: Long = 1,
    val ownerId: Long = 2,
    val title: String = "Диплом",
    val size: Int = 2
)