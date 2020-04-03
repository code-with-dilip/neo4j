package com.learnneo4j

import com.learnneo4j.repository.PersonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class LearnNeo4jApplication

fun main(args: Array<String>) {
	runApplication<LearnNeo4jApplication>(*args)

}

