package com.studiobff.studiobfftest.services

import com.studiobff.studiobfftest.models.ElasticSearchResponse
import com.studiobff.studiobfftest.models.Filters
import com.studiobff.studiobfftest.models.InteractionTrigger
import com.studiobff.studiobfftest.repositories.InteractionTriggersRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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

    fun findByAccountId(accountId: String, params: Filters): ElasticSearchResponse{
        return getElasticResponse(interactionTriggersRepository.findByAccountId(accountId, pageableBuild(params)))
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

    fun pageableBuild(filters: Filters): PageRequest {
        try {
            val order = filters.order_by?.split(":")?.toTypedArray()

            var orderBy = order?.get(0)
            val orderDirection = order?.get(1)


            val sort = when (orderDirection.toLowerCase()) {
                "asc" -> Sort.by(orderBy).ascending()
                "desc" -> Sort.by(orderBy).descending()
                else -> throw Exception("Unexpected error")
            }

            val defaultSort = Sort.by("updatedAt").descending()

            return PageRequest.of((filters.page - 1), filters.per_page, sort.and(defaultSort))
        } catch (e: Exception) {
            throw Exception("Unexpected error", e)
        }
    }

}