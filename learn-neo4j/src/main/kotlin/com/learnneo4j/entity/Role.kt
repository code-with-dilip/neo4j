package com.learnneo4j.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode

@RelationshipEntity(type = "ROLE")
data class Role(@Id @GeneratedValue val id: Long?=null,
                val role: String,
                @StartNode
                val start: Person,
                @StartNode
                val end: Team)