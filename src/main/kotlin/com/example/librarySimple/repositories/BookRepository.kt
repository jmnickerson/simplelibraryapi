package com.example.librarySimple.repositories

import com.example.librarySimple.models.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Long>