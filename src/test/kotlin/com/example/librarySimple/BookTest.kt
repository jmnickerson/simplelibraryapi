package com.example.librarySimple

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class BookTest() {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `List articles`() {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/books")
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(MockMvcResultMatchers.content().string("{}"))  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                MockMvcResultMatchers.content().json("[{\"author\":\"J.R.R Tolkein\",\"title\":\"The Hobbit\"}]")
            )
//            .andExpect(jsonPath("\$.[0].slug").value(spring5Article.slug))
//            .andExpect(jsonPath("\$.[1].author.login").value(juergen.login))
//            .andExpect(jsonPath("\$.[1].slug").value(spring43Article.slug))
    }
}