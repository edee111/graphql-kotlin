package com.grapthql.kotlin.graphqlkotlin

import javax.persistence.*

@Entity
@Table(name = "page")
class PageDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var number: Int,
    var content: String,

    @ManyToOne
    @JoinColumn(name = "book_id")
    var book: BookDo? = null
)