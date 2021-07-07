package com.studiobff.studiobfftest.repositories

import com.studiobff.studiobfftest.models.InteractionTrigger
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.core.SearchHits
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.stereotype.Repository
import java.awt.print.Pageable

@Repository
@EnableElasticsearchRepositories
interface InteractionTriggersRepository: ElasticsearchRepository<InteractionTrigger, String>{
    fun findByChannel(name: String): SearchHits<InteractionTrigger>

    fun findByAccountId(accountId: String, pageRequest: PageRequest): SearchHits<InteractionTrigger>

    @Query("{\"bool\": {\n" +
        "    \"must\": [\n" +
        "        {\n" +
        "            \"terms\": {\n" +
        "                \"account_id\": [\n" +
        "                    \"account-1\"\n" +
        "                ]\n" +
        "            }\n" +
        "        },\n" +
        "        {\n" +
        "            \"multi_match\": {\n" +
        "                \"query\": \"flow name\",\n" +
        "                \"fields\": [\n" +
        "                    \"flow_name\",\n" +
        "                    \"friendly_name\",\n" +
        "                    \"phone_number\"\n" +
        "                ]\n" +
        "            }\n" +
        "        }\n" +
        "    ]\n" +
        "}}")
    fun findByMultipleFields(accountId: String, searchInput: String): SearchHits<InteractionTrigger>

    fun findByAccountIdAndFlowId(accountId: String, flowId: String): SearchHits<InteractionTrigger>
}