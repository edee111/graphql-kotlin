package com.grapthql.kotlin.graphqlkotlin

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/book"])
@Transactional
class BookController(
    private val bookRepository: BookRepository,
) {

    @GetMapping
    @ResponseBody
    fun findAll(): List<BookDo> {
        bookRepository.save(BookDo(name = "Knizecka"))
        return bookRepository.findAll()
    }
}