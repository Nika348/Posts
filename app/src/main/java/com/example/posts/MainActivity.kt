package com.example.posts

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()

fun main() {
    println("ООП: Объекты и классы")
}

data class Post(
    val idPost: Int,
    val ownerId: Long,
    val fromId: Long,
    val createdBy: Long,
    val date: Long,
    val text: String,
    val replyOwnerId: Long,
    val replyPostId: Long,
    val friendsOnly: Boolean,
    val comments: Int,
    val copyright: String,
    val likes: Likes?,
    val reposts: Post?,
    val views: Post?,
    val postType: Post?,
    val postSource: Post?,
    val geo: Post?,
    val signerId: Long,
    var copyHistory: Post?,
    val canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    val isPinned: Boolean,
    var markedAsAds: Boolean,
    var isFavorite: Boolean,
    val postponedId: Int,
    var attachments: Array<Attachment> = emptyArray<Attachment>()
)

data class Comment(
    val postId: Int,
    val from_id: Int,
    val date: Int,
    val text: String,
)

class Likes {
}

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var nextId: Int = 0

    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) {
            post.copy(idPost = 0)
        } else {
            post.copy(idPost = nextId)
        }
        nextId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((idPost, newPost) in posts.withIndex()) {
            if (newPost.idPost == post.idPost) {
                posts[idPost] = newPost.copy(ownerId = newPost.ownerId, date = newPost.date)
                return true
            }
        }
        return false
    }


    fun createComment(comment: Comment, nextId: Int): Comment {
        for (post in posts) {
            if (nextId == comment.postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Нельзя добавить комментарий к несуществующему посту")

    }
}

class PostNotFoundException(message: String) : RuntimeException(message) {

}