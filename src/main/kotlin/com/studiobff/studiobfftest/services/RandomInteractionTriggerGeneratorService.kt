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
        val accountIds = listOf("account-1")
        interactionTriggersRepository.deleteAll()

        val interactionTriggerList: MutableList<InteractionTrigger> = mutableListOf()

        accountIds.forEach { accountId ->
            repeat(triggers_count) { index ->
                println("Creating a new interaction trigger with id $index")
                val interactionTrigger = generateRandomTrigger(index.toString(), triggers_count, accountId)
                interactionTriggerList.add(interactionTrigger)
            }
        }

        interactionTriggersRepository.saveAll(interactionTriggerList)
    }

    fun generateRandomTrigger(id: String, triggers_count: Int, accountId: String): InteractionTrigger{
       return InteractionTrigger(
           id = "${id}-${accountId}",
           accountId = accountId,
           channel = generatorService.generateRandomChannelType(),
           phoneNumber = generatorService.generatePhoneNumber(),
           phoneNumberId = generatorService.generatePhoneNumberId(triggers_count),
           flowId = generatorService.generateRandomFlowId(triggers_count),
           flowName =  generatorService.generateRandomFlowName(),
           friendlyName = generatorService.generateRandomFriendlyName(),
           updated_at = Instant.now()
       )
    }


}