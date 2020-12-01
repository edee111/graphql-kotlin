package com.grapthql.kotlin.graphqlkotlin

import javax.persistence.*


@Entity
@Table(name = "book")
class BookDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id: Int? = null,
    @Column
    var name: String,
)