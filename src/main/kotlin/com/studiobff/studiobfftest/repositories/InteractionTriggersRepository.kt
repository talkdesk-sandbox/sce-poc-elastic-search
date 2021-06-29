package com.studiobff.studiobfftest.repositories

import com.studiobff.studiobfftest.models.InteractionTrigger
import org.springframework.context.annotation.Bean
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.stereotype.Repository

@Repository
@EnableElasticsearchRepositories
interface InteractionTriggersRepository: ElasticsearchRepository<InteractionTrigger, String>{
    fun findByChannel(name: String): List<InteractionTrigger>
/*
    // NativeQuery is needed
    fun findByChannelOrFriendlyName(field: String): List<InteractionTrigger>
*/
}