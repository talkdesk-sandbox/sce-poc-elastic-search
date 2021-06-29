package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.InteractionTrigger
import org.springframework.stereotype.Service

@Service
class BeautifyService {
    fun beautify(interactionTriggers: List<InteractionTrigger>): String{
        var output = ""

        interactionTriggers.forEach {
            output += "$it <br />"
        }

        return output
    }
}