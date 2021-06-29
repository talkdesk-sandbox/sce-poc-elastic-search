package com.studiobff.studiobfftest.configuration.elasticSearch

interface ElasticSearchConfiguration {
    fun getElasticHostPort(): String
    fun getIndexName(): String
    fun getScheme(): String
    fun getUser(): String?
    fun getPass(): String?
}