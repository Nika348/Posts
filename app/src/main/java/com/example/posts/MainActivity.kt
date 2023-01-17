package com.example.posts

data class Post(
    val idPost: Int,
    val ownerId: Long,
    val created_by: Long,
    val date: Long,
    val text: String,
    val reposts: Int,
    val views: Int,
    val canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isFavorite: Boolean,
    val likes: Likes?
)

fun main(args: Array<String>) {
    println("Hello World!")
}

class Likes {
}

object WallService {
    var posts = emptyArray<Post>()
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
}