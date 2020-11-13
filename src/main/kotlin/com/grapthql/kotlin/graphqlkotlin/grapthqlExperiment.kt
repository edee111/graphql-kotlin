package com.grapthql.kotlin.graphqlkotlin

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

data class Book(val id: String, val name: String)

@Component
class BookResolver : GraphQLQueryResolver {
    // this method name needs to be same and in the schema
    fun books(): List<Book> {
        val book1 = Book("1", "name1")
        val book2 = Book("2", "name2")
        return listOf(book1, book2)
    }
}