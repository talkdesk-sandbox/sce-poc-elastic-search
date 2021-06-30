package com.studiobff.studiobfftest.configuration.elasticSearch

import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients




@Configuration
class RestClientConfig(
): AbstractElasticsearchConfiguration() {

    @Override
    @Bean
    override fun elasticsearchClient(): RestHighLevelClient {
        val clientConfiguration: ClientConfiguration.MaybeSecureClientConfigurationBuilder = ClientConfiguration.builder()
            .connectedTo("localhost:9200")

        return RestClients.create(clientConfiguration.build()).rest()
    }
}