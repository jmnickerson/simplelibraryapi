package com.example.librarySimple

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class BooksControllerTest() {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `List articles`() {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/books")
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json("[{\"author\":\"J.R.R Tolkein\",\"title\":\"The Hobbit\"}]")
            )
    }
}