package com.learnneo4j.initliaze

import com.learnneo4j.entity.Person
import com.learnneo4j.entity.Role
import com.learnneo4j.entity.Team
import com.learnneo4j.repository.PersonRepository
import com.learnneo4j.repository.RoleRepository
import com.learnneo4j.repository.TeamRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val personRepository: PersonRepository,
                      val teamRepository: TeamRepository,
                      val roleRepository: RoleRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Inside Initialize")
        personRepository.deleteAll()
        teamRepository.deleteAll()


        val p1 = Person(name = "Dilip", role = "Lead Engineer")
        val p2 = Person(name = "Adam", role = "Senior Engineering Manager")
        val p3 = Person(name = "Niranjan", role = "Senior Engineer")
        val p4 = Person(name = "Sean", role = "Engineer")


        addingPersonsToDb(listOf(p1, p2, p3, p4))
        val team = Team(name = "Lamda")
        addNewTeam(team)

        this.addingPersonsToTeam(team, listOf(p1, p2, p3, p4))
        println("Compeleted the mapping and saved the Person")

//        addRole("LEAD_ENGINEER", p1, team)

    }

    private fun addRole(role: String, p1: Person, team: Team) {

        val role = Role(role=role, start = p1, end =  team)
      //  p1.addRole(role)
        roleRepository.save(role)
        personRepository.save(p1)
    }

    private fun addNewTeam(team: Team) {
        teamRepository.save(team)
        println("Persisted Team is $team")
    }

    private fun addingPersonsToTeam(team : Team , personList : List<Person>) {
        personList.
                forEach {
                    team.addedToTeam(it)
                }
        teamRepository.save(team)
        println("TeamMembers are added to the team $team")
    }

    private fun addingPersonsToDb(personData: List<Person>) {

        personRepository.saveAll(personData)

    }

}