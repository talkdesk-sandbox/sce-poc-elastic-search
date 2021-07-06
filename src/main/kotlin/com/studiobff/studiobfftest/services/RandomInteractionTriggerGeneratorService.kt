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
    var accountTotal = 0

    fun generateRandomTriggers(wipe: Boolean, triggers: Int, accounts: Int, batches: Int){
        val triggers_count = triggers
        val accountIds = ArrayList<String>()
        val accountIncrement = accounts

        if(wipe) {
            accountTotal = 0
            interactionTriggersRepository.deleteAll()
        }

        for(batch in 1..batches) {
            val accountCurrent = accountTotal
            accountTotal += accountIncrement

            for (i in accountCurrent until accountTotal) {
                accountIds.add("account-$i")
            }

            val interactionTriggerList: MutableList<InteractionTrigger> = mutableListOf()

            accountIds.forEach { accountId ->
                repeat(triggers_count) { index ->
                    println("For account $accountId Creating a new interaction trigger with id $index")
                    val interactionTrigger = generateRandomTrigger(index.toString(), triggers_count, accountId)
                    interactionTriggerList.add(interactionTrigger)
                }
            }

            interactionTriggersRepository.saveAll(interactionTriggerList)
        }
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