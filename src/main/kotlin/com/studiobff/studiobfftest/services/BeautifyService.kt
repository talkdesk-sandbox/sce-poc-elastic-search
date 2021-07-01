package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.InteractionTrigger
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service

@Service
class BeautifyService {
    fun beautify(interactionTriggers: List<InteractionTrigger>): String{
        var output = "["

        interactionTriggers.forEach {
            output += Json.encodeToString(it)
        }

        output +="]"

        return output
    }
}