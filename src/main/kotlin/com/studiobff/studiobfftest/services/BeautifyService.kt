package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.ElasticSearchResponse
import com.studiobff.studiobfftest.models.InteractionTrigger
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import java.util.HashMap

@Service
class BeautifyService {
    fun beautify(interactionTriggers: List<InteractionTrigger>): String{
        var output = "["

        interactionTriggers.forEach {
            output += Json.encodeToString(it)
        }

        output +="]"

        return output;

    }

    fun beautify(response: ElasticSearchResponse): String{
        return  Json.encodeToString(response)
    }
}