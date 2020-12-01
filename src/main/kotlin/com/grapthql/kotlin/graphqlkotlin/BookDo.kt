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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = [CascadeType.ALL])
    var pages: List<PageDo>? = null,
)