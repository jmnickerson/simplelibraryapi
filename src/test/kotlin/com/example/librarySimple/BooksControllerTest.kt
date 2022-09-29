package com.example.librarySimple

import com.example.librarySimple.models.Book
import com.example.librarySimple.repositories.BookRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest
class BooksControllerTest() {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var mockBookRepository: BookRepository

    @Test
    fun `List articles`() {

        every { mockBookRepository.findAll()}.returns(listOf(Book(author = "J.R.R. Tolkein", title = "The Hobbit")))

        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/books")
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().string("[{\"id\":0,\"title\":\"The Hobbit\",\"author\":\"J.R.R. Tolkein\"}]")
            )
    }
}