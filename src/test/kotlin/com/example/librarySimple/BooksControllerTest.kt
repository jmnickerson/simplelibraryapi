package com.example.librarySimple

import com.example.librarySimple.repositories.BookRepository
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class BooksControllerTest() {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var mockBookRepository: BookRepository

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