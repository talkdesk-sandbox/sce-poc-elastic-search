package com.studiobff.studiobfftest.repositories

import com.studiobff.studiobfftest.models.InteractionTrigger
import org.springframework.context.annotation.Bean
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.stereotype.Repository

@Repository
@EnableElasticsearchRepositories
interface InteractionTriggersRepository: ElasticsearchRepository<InteractionTrigger, String>{
    fun findByChannel(name: String): List<InteractionTrigger>

    fun findByAccountId(accountId: String): List<InteractionTrigger>

    @Query("{\"bool\": { \"must\": [{\"match\": {\"account_id\": {\"query\": \"?0\"}}},{\"wildcard\": {\"flow_name\": \"?1\"}}]}}")
    fun findByMultipleFields(accountId: String, field: String): List<InteractionTrigger>

}