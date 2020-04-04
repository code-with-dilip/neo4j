package com.learnneo4j.repository

import com.learnneo4j.entity.Team
import org.springframework.data.neo4j.repository.Neo4jRepository

interface TeamRepository: Neo4jRepository<Team, Long> {
}