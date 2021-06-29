package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.repositories.InteractionTriggersRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class InteractionTriggersSearchService(
    private val interactionTriggersRepository: InteractionTriggersRepository,
) {

    fun findAllInteractionTriggers(): List<InteractionTrigger>{
        val interactionTriggerList: MutableList<InteractionTrigger> =  ArrayList()

        interactionTriggersRepository.findAll().forEach {
            interactionTriggerList.add(it!!)
       }

        return interactionTriggerList;
    }

    fun findByChannel(channel: String): List<InteractionTrigger>{
        val interactionTriggerList: MutableList<InteractionTrigger> =  ArrayList()

        interactionTriggersRepository.findByChannel(channel).forEach {
            interactionTriggerList.add(it!!)
        }

        return interactionTriggerList;
    }

   /* fun findByChannelAndFriendlyName(filter: String): List<InteractionTrigger>{
        val interactionTriggerList: MutableList<InteractionTrigger> =  ArrayList()

        interactionTriggersRepository.findByChannelOrFriendlyName(filter).forEach {
            interactionTriggerList.add(it!!)
        }

        return interactionTriggerList;
    }*/

    // Filter by Channel AND/OR Resource Name
    // Find by number/ touchpoint OR Flow Name OR Friendly Name
    // Sort by Friendly Name
    // Sort By Touchpoint
/*
    fun findByQuery(query: QueryBuilder) {
        val nativeSearchQueryBuilder = NativeSearchQueryBuilder().withQuery(query)
        return elasticsearchTemplate.search(nativeSearchQueryBuilder.build(), InteractionTrigger::class.java)
    }*/
}