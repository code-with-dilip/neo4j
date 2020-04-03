package com.learnneo4j.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship
import java.util.*


@NodeEntity
data class Person(@Id @GeneratedValue val id: Long? = null,
                  val name : String,
                  val role : String ){

    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
    var teammates: MutableSet<Person>? = null

    @Relationship(type = "PART_OF")
    var teamMateRoles: MutableSet<Team>? = null

    fun worksWith(person: Person?) {
        if (teammates == null) {
            teammates = HashSet()
        }
        teammates!!.add(person!!)
    }

    fun partOf(team : Team){
        if (teamMateRoles == null) {
            teamMateRoles = HashSet()
        }
        teamMateRoles!!.add(team)


    }



}