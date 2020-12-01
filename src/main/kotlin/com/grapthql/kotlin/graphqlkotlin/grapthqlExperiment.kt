package com.grapthql.kotlin.graphqlkotlin

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

data class Book(val id: Int?, val name: String) {
    companion object  {
        fun of(bookDo: BookDo): Book = Book(bookDo.id, bookDo.name)
    }
}

@Component
@Transactional
class BookResolver(
    private val bookRepository: BookRepository,
) : GraphQLQueryResolver {
    // this method name needs to be same and in the schema
    fun books(id: Int?): List<Book> {
        var resultBooks = bookRepository.findAll()
        if (id != null) {
           resultBooks = resultBooks.filter { it.id == id }
        }

        return resultBooks.map(Book::of)
    }
}