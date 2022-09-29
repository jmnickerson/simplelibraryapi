package com.example.librarySimple.controller

import com.example.librarySimple.model.Book
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BooksController {

    @GetMapping
    fun getBooks(): List<Book> {
        return listOf(Book(author = "J.R.R Tolkein", title = "The Hobbit"), Book(author = "C.S. Lewis", title = "The Lion the Witch and the Wardrobe"))
    }
}