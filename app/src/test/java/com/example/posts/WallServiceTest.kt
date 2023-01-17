package com.example.posts

import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun testIdNotZero() {
        val service = WallService

        val result = service.add(Post(1,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))

        assertTrue(result.idPost > 0)
    }
    @Test
    fun updateFalse() {
        val service = WallService
        val test1 = service.add(Post(1,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))
        val test2 = service.add(Post(2,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))
        val test3 = service.add(Post(3,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))
        val updatePost = Post(6,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null)

        service.add(test1)
        service.add(test2)
        service.add(test3)
        val result = service.update(updatePost)

        assertFalse(result)
    }

    @Test
    fun updateTrue() {

        val service = WallService
        val test1 = service.add(Post(1,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))
        val test2 = service.add(Post(2,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))
        val test3 = service.add(Post(3,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null))
        val update = Post(3,1, 1, 17012023, "TEXT", 1, 200, false, false, false, true, null)

        service.add(test1)
        service.add(test2)
        service.add(test3)
        val result = service.update(update)

        assertTrue(result)
    }
}