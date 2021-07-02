package com.studiobff.studiobfftest.controller

import com.studiobff.studiobfftest.services.BeautifyService
import com.studiobff.studiobfftest.services.InteractionTriggerUpdateService
import com.studiobff.studiobfftest.services.InteractionTriggersSearchService
import com.studiobff.studiobfftest.services.RandomInteractionTriggerGeneratorService
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
    fun set(): String{
        generatorService.generateRandomTriggers()
        return "Added random Interaction Triggers"
    }

    @RequestMapping("/findByChannel", method = [RequestMethod.GET])
    fun getByChannel(
        @RequestBody body: Map<String, String>,
    ): String{
        body["channel"]?.let {
            return beautifyService.beautify(searchService.findByChannel(it))
        }

        return "Error finding by channel"
    }

    @RequestMapping("/findByAccountId", method = [RequestMethod.GET])
    fun getByChannel(
        @RequestParam accountId: String
    ): String{

        accountId.ifEmpty {
            return "Error finding by multiple fields"
        }

        return beautifyService.beautify(searchService.findByAccountId(accountId))
    }

   @RequestMapping("/findByMultipleFields", method = [RequestMethod.GET])
    fun getByMultipleFields(
        @RequestParam searchInput: String,
        @RequestParam accountId: String
    ): String{

       searchInput.ifEmpty {
            return "Error finding by multiple fields"
        }

        return beautifyService.beautify(searchService.findByMultipleFields(accountId, searchInput))
    }

    @RequestMapping("/updateFlowName", method = [RequestMethod.POST])
    fun getByChannel(
        @RequestParam flowId: String,
        @RequestParam flowName: String,
        @RequestParam accountId: String
    ): String{

        accountId.ifEmpty {
            return "Error finding by multiple fields"
        }

        flowId.ifEmpty {
            return "Error finding by multiple fields"
        }

        flowName.ifEmpty {
            return "Error finding by multiple fields"
        }

        return beautifyService.beautify(updateService.updateFlowName(accountId, flowId, flowName))
    }

}