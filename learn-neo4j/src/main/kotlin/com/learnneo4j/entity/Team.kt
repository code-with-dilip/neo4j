package com.learnneo4j.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class Team(@Id @GeneratedValue val id: Long? = null,
                val name : String)