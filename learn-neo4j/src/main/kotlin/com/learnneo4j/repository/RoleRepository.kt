package com.learnneo4j.repository

import com.learnneo4j.entity.Role
import org.springframework.data.neo4j.repository.Neo4jRepository

interface RoleRepository : Neo4jRepository<Role, Long> {
}