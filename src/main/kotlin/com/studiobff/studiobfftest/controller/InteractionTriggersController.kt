package com.studiobff.studiobfftest.controller

import com.studiobff.studiobfftest.models.ElasticSearchResponse
import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.services.BeautifyService
import com.studiobff.studiobfftest.services.InteractionTriggerUpdateService
import com.studiobff.studiobfftest.services.InteractionTriggersSearchService
import com.studiobff.studiobfftest.services.RandomInteractionTriggerGeneratorService
import kotlinx.serialization.internal.throwMissingFieldException
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bff/interaction_triggers")
class InteractionTriggersController(
    private val searchService: InteractionTriggersSearchService,
    private val updateService: InteractionTriggerUpdateService,
    private val generatorService: RandomInteractionTriggerGeneratorService,
    private val beautifyService: BeautifyService,
) {
    @RequestMapping("/", method = [RequestMethod.POST])
    fun set(
        @RequestParam wipe: Boolean = true,
        @RequestParam triggers: Int = 200,
        @RequestParam accounts: Int = 10,
        @RequestParam batches: Int = 1
    ): String{
        generatorService.generateRandomTriggers(wipe, triggers, accounts, batches)
        return "Added random Interaction Triggers"
    }

    @RequestMapping("/findByChannel", method = [RequestMethod.GET])
    fun getByChannel(
        @RequestBody body: Map<String, String>,
    ): ElasticSearchResponse{
        body["channel"]?.let {
            return searchService.findByChannel(it)
        }

        throw Exception();
    }

    @RequestMapping("/findByAccountId", method = [RequestMethod.GET])
    fun getByChannel(
        @RequestParam accountId: String
    ): ElasticSearchResponse{

        return searchService.findByAccountId(accountId)
    }

   @RequestMapping("/findByMultipleFields", method = [RequestMethod.GET])
    fun getByMultipleFields(
        @RequestParam searchInput: String,
        @RequestParam accountId: String
    ): ElasticSearchResponse {


        return searchService.findByMultipleFields(accountId, searchInput)
    }

    @RequestMapping("/updateFlowName", method = [RequestMethod.POST])
    fun getByChannel(
        @RequestParam flowId: String,
        @RequestParam flowName: String,
        @RequestParam accountId: String
    ): List<InteractionTrigger>{


        return updateService.updateFlowName(accountId, flowId, flowName)
    }

}