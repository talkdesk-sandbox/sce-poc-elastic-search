package com.studiobff.studiobfftest.models

import kotlinx.serialization.Serializable
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Setting
import java.time.Instant

@Setting(settingPath = "settings/flowAnalyzer.json")
@Document(indexName = "interactiontriggerindex")
data class InteractionTrigger (

    @Id
    val id: String,

    @Field(type = FieldType.Keyword, name = "account_id")
    val accountId: String,

    @Field(type = FieldType.Keyword, name = "channel")
    val channel: String,

    @Field(type = FieldType.Text, name = "phone_number", analyzer = "custom_analyzer_number")
    val phoneNumber: String,

    @Field(type = FieldType.Keyword, name = "phone_number_id")
    val phoneNumberId: String,

    @Field(type = FieldType.Text, name = "friendly_name")
    val friendlyName: String,

    @Field(type = FieldType.Keyword, name = "flow_id")
    val flowId: String,

    @Field(type = FieldType.Text, name = "flow_name", analyzer = "custom_analyzer")
    val flowName: String,

    @Field(type = FieldType.Date, pattern = ["yyyy-MM-dd'T'HH:mm:ss.SSSZZ"])
    val updated_at: Instant
    )