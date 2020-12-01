package com.grapthql.kotlin.graphqlkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class GraphqlKotlinApplication

fun main(args: Array<String>) {
	runApplication<GraphqlKotlinApplication>(*args)
}
