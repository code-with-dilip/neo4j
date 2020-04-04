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

    /*@Relationship(type = "ROLE", direction = Relationship.OUTGOING)
    var roleRelationship: MutableSet<Role>? = null*/

    fun worksWith(person: Person?) {
        if (teammates == null) {
            teammates = HashSet()
        }
        teammates!!.add(person!!)
    }

   /* fun addRole(role: Role) {
        this.roleRelationship = role
    }*/

}