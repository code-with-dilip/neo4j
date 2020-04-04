package com.learnneo4j.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Team(@Id @GeneratedValue val id: Long? = null,
                val name : String){

    @Relationship(type= "PART_OF", direction = Relationship.INCOMING)
    var teamList : MutableSet<Person>? = null

    fun addedToTeam(person: Person){
        teamList = teamList ?: HashSet()
        teamList?.add(person)

    }
}