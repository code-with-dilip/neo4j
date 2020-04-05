package com.learnneo4j.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship
import java.util.*


@NodeEntity(label = "Person")
class Person(@Id @GeneratedValue val id: Long? = null,
                  val name : String,
                  val role : String,
                  @Relationship(type = "ROLE")
                  @JsonIgnore
                  val roleRelationship: MutableSet<Role> = mutableSetOf()){

    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
    var teammates: MutableSet<Person>? = null


   /* fun worksWith(person: Person?) {
        if (teammates == null) {
            teammates = HashSet()
        }
        teammates!!.add(person!!)
    }*/

    fun addRole(team : Team, role : String) {
        val role = Role(start = this, role = role, end = team)
        this.roleRelationship.add(role)
    }

    override fun toString(): String {
        return "Person(id=$id, name='$name', teammates=$teammates)"
    }

}