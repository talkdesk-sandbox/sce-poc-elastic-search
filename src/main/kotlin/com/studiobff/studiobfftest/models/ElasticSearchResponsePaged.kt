package com.studiobff.studiobfftest.models

import org.springframework.data.domain.Page

data class ElasticSearchResponsePaged(val metadata: Page<List<InteractionTrigger>>, val count: Long = 0)