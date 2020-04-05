package com.learnneo4j.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "ROLE")
class Role(@Id @GeneratedValue val id: Long?=null,
                @StartNode
                @JsonIgnore
                val start: Person,
                val role: String,
                @EndNode
                @JsonIgnore
                val end: Team){

    override fun toString(): String {
        return "Role(id=$id,  role='$role)"
    }
}
