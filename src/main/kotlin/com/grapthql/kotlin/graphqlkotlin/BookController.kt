package com.grapthql.kotlin.graphqlkotlin

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/book"])
@Transactional
class BookController(
    private val bookRepository: BookRepository,
    private val pageRepository: PageRepository,
) {

    @GetMapping
    @ResponseBody
    fun findAll(): List<Book> {
        createSingleBook()
        return bookRepository.findAll().map(
            Book::of
        )
    }

    @GetMapping("/{bookId}/page")
    @ResponseBody
    fun pagesOfBook(@PathVariable bookId: Int): List<PageDo> {
        return pageRepository.findByBookId(bookId)
    }

    private fun createSingleBook() {
        val pages = (1..2).map { PageDo(number = it, content = "Content of page $it") }
        val book = bookRepository.save(
            BookDo(name = "Knizecka", pages = pages)
        )
        pages.forEach { it.book = book }
        pageRepository.saveAll(pages)
    }
}