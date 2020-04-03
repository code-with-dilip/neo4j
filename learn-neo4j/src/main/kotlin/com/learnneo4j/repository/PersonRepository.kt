package com.learnneo4j.repository

import com.learnneo4j.entity.Person
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.CrudRepository


interface PersonRepository : Neo4jRepository<Person, Long> {

    fun findByName(name: String?): Person?

}

