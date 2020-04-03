package com.learnneo4j.initliaze

import com.learnneo4j.entity.Person
import com.learnneo4j.entity.Team
import com.learnneo4j.repository.PersonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val personRepository: PersonRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Inside Initialize")
        personRepository.deleteAll()
        personRepository.deleteAll()


        val p1 = Person(name = "Dilip", role = "Lead Engineer")
        val p2 = Person(name = "Adam", role = "Senior Engineering Manager")
        val p3 = Person(name = "Niranjan", role = "Senior Engineer")
        val p4 = Person(name = "Sean", role = "Engineer")


        addingPersonsToDb(listOf(p1, p2, p3, p4))

        val team = Team(name = "Lamda")


        /*val person = personRepository.findByName("Dilip")
        person?.worksWith(p2)
        person?.worksWith(p3)
        person?.worksWith(p4)
        personRepository.save(person!!)*/
        println("Compeleted the mapping and saved the Person")

    }

    private fun addingPersonsToDb(personData: List<Person>) {

        personRepository.saveAll(personData)

    }

}