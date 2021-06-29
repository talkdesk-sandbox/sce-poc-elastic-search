package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.repositories.InteractionTriggersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RandomInteractionTriggerGeneratorService(
    private val interactionTriggersRepository: InteractionTriggersRepository,
    private val generatorService: RandomFieldsGeneratorService

) {

    fun generateRandomTriggers(){
        interactionTriggersRepository.deleteAll()
        repeat(10) { index ->
            println("Creating a new interaction trigger with id $index")
            val interactionTrigger = generateRandomTrigger(index.toString())
            interactionTriggersRepository.save(interactionTrigger)
        }
    }

    fun generateRandomTrigger(id: String): InteractionTrigger{
       return InteractionTrigger(
           id = id,
           channel = generatorService.generateRandomChannelType(),
           phoneNumber = generatorService.generatePhoneNumber(),
           flowName =  generatorService.generateRandomFlowName(),
           friendlyName = generatorService.generateRandomFriendlyName()
       )
    }


}