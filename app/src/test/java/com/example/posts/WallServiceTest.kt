package com.example.posts

import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun testIdNotZero() {
        val service = WallService

        val result = service.add(
            Post(
                1, 1, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )

        assertTrue(result.idPost > 0)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        val test1 = service.add(
            Post(
                1, 1, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )
        val test2 = service.add(
            Post(
                2, 2, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )
        val test3 = service.add(
            Post(
                3, 3, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )
        val updatePost = (Post(
            6, 1, 2, 2, 1205202,
            "TEXT", 1, 1, false, 14,
            "text", null, null, null, null, null, null,
            1, null, true, true, true, true,
            true, true, 1
        ))

        service.add(test1)
        service.add(test2)
        service.add(test3)
        val result = service.update(updatePost)

        assertFalse(result)
    }

    @Test
    fun updateTrue() {

        val service = WallService
        val test1 = service.add(
            Post(
                1, 1, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )
        val test2 = service.add(
            Post(
                1, 1, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )
        val test3 = service.add(
            Post(
                1, 1, 2, 2, 1205202,
                "TEXT", 1, 1, false, 14,
                "text", null, null, null, null, null, null,
                1, null, true, true, true, true,
                true, true, 1
            )
        )
        val update = Post(
            3, 1, 2, 2, 1205202,
            "TEXT", 1, 1, false, 14,
            "text", null, null, null, null, null, null,
            1, null, true, true, true, true,
            true, true, 1
        )

        service.add(test1)
        service.add(test2)
        service.add(test3)
        val result = service.update(update)

        assertTrue(result)
    }

    class WallServiceTest {
        @Test
        fun addComment() {

            val service = WallService
            val test1 = service.add(
                Post(
                    1, 1, 2, 2, 1205202,
                    "TEXT", 1, 1, false, 14,
                    "text", null, null, null, null, null, null,
                    1, null, true, true, true, true,
                    true, true, 1
                )
            )
            val testComment = Comment(1, 2, 25012023, "text comment")

            WallService.add(test1)
            WallService.createComment(testComment, 1)
            assertEquals("text comment", testComment.text)
        }

        @Test(expected = PostNotFoundException::class)
        fun createCommentThrowException() {
            val service = WallService
            val comment = Comment(postId = 2, 1, 25012023, "")
            service.createComment(comment, 1)
        }
    }
}