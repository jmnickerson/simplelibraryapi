package com.example.librarySimple.controllers

import com.example.librarySimple.models.Book
import com.example.librarySimple.repositories.BookRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BooksController(val bookRepository: BookRepository) {

    @GetMapping
    fun getBooks(): List<Book> {
        return bookRepository.findAll() as List<Book>
    }

    @PostMapping
    fun addBook(book: Book): Book {
        return bookRepository.save(book)
    }

    @GetMapping("/seed")
    fun seedBooks() {
        bookRepository.save(Book(author = "J.R.R Tolkein", title = "The Hobbit"))
        bookRepository.save(Book(author = "C.S. Lewis", title = "The Horse and the Boy"))
    }
}