package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.repositories.InteractionTriggersRepository
import org.springframework.stereotype.Service

@Service
class InteractionTriggerUpdateService(
    private val interactionTriggersRepository: InteractionTriggersRepository,
) {

    fun updateFlowName(accountId: String, flowId :String , flowName: String): List<InteractionTrigger>{
        val interactionTriggerList = interactionTriggersRepository.findByAccountIdAndFlowId(accountId, flowId)
        val newInteractionTriggersList = mutableListOf<InteractionTrigger>()
        interactionTriggerList.forEach {
            newInteractionTriggersList.add(it.copy(flowName = flowName))

        }

        interactionTriggersRepository.saveAll(newInteractionTriggersList)
        return newInteractionTriggersList
    }
}