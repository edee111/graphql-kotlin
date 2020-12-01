package com.grapthql.kotlin.graphqlkotlin

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface PageRepository : JpaRepository<PageDo, Int>, JpaSpecificationExecutor<PageDo> {
    fun findByBookId(bookId: Int): List<PageDo>
}