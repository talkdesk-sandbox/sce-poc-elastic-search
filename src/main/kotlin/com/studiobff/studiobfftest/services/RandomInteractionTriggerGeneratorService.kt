package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.repositories.InteractionTriggersRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class RandomInteractionTriggerGeneratorService(
    private val interactionTriggersRepository: InteractionTriggersRepository,
    private val generatorService: RandomFieldsGeneratorService

) {

    fun generateRandomTriggers(){
        val triggers_count = 10
        interactionTriggersRepository.deleteAll()
        repeat(triggers_count) { index ->
            println("Creating a new interaction trigger with id $index")
            val interactionTrigger = generateRandomTrigger(index.toString(), triggers_count)
            interactionTriggersRepository.save(interactionTrigger)
        }
    }

    fun generateRandomTrigger(id: String, triggers_count: Int): InteractionTrigger{
       return InteractionTrigger(
           id = id,
           accountId = generatorService.generateRandomAccount(triggers_count),
           channel = generatorService.generateRandomChannelType(),
           phoneNumber = generatorService.generatePhoneNumber(),
           flowName =  generatorService.generateRandomFlowName(),
           friendlyName = generatorService.generateRandomFriendlyName(),
           updated_at = Instant.now()
       )
    }


}