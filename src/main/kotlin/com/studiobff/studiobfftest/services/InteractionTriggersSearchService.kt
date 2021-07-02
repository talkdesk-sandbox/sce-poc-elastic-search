package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.ElasticSearchResponse
import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.repositories.InteractionTriggersRepository
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchTemplate
import org.springframework.data.elasticsearch.core.SearchHits
import org.springframework.stereotype.Service
import java.util.*


@Service
class InteractionTriggersSearchService(
    private val interactionTriggersRepository: InteractionTriggersRepository,

) {
    fun findByChannel(channel: String): ElasticSearchResponse{
        return getElasticResponse(interactionTriggersRepository.findByChannel(channel))
    }

    fun findByAccountId(accountId: String): ElasticSearchResponse{
        return getElasticResponse(interactionTriggersRepository.findByAccountId(accountId))
    }

   fun findByMultipleFields(accountId: String, filter: String): ElasticSearchResponse{
       return getElasticResponse(interactionTriggersRepository.findByMultipleFields(accountId, filter))
    }

    fun getElasticResponse(searchResponse :SearchHits<InteractionTrigger>): ElasticSearchResponse {
        val interactionTriggerList: MutableList<InteractionTrigger> =  ArrayList()
        searchResponse.forEach { searchHit ->
            interactionTriggerList.add(searchHit.content)
        }

        return ElasticSearchResponse(metadata = interactionTriggerList, count = searchResponse.totalHits);

    }

}