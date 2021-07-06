package com.studiobff.studiobfftest.services

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.studiobff.studiobfftest.models.ElasticSearchResponse
import com.studiobff.studiobfftest.models.InteractionTrigger
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service

@Service
class BeautifyService {

    fun beautify(interactionTriggers: List<InteractionTrigger>): String{
        var objectMapper = jacksonObjectMapper().apply{
            findAndRegisterModules()
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            configure(SerializationFeature.INDENT_OUTPUT, true)
            configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
            propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        }

        return objectMapper.writeValueAsString(interactionTriggers);
    }

    fun beautify(response: ElasticSearchResponse): String{
        var objectMapper = jacksonObjectMapper().apply{
            findAndRegisterModules()
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            configure(SerializationFeature.INDENT_OUTPUT, true)
            configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
            propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        }

        return objectMapper.writeValueAsString(response);
    }
}