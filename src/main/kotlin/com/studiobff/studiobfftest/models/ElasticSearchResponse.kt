package com.studiobff.studiobfftest.models

import kotlinx.serialization.Serializable

@Serializable
data class ElasticSearchResponse(val metadata: List<InteractionTrigger>, val count: Long = 0)