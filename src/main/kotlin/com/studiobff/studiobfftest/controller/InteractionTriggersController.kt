package com.studiobff.studiobfftest.controller

import com.studiobff.studiobfftest.services.BeautifyService
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
    private val generatorService: RandomInteractionTriggerGeneratorService,
    private val beautifyService: BeautifyService,
) {
    @RequestMapping("/", method = [RequestMethod.POST])
    fun set(): String{
        generatorService.generateRandomTriggers()
        return "Added random Interaction Triggers"
    }

    @RequestMapping("/", method = [RequestMethod.GET])
    fun getAll(): String{
        return beautifyService.beautify(searchService.findAllInteractionTriggers())
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

/*    @RequestMapping("/findByChannelOrFriendlyName", method = [RequestMethod.GET])
    fun getByAllFields(
        @RequestParam field: String
    ): String{

        field.ifEmpty {
            return "Error finding by channel or friendly name"
        }

        return beautifyService.beautify(searchService.findByChannelAndFriendlyName(field))
    }*/
}