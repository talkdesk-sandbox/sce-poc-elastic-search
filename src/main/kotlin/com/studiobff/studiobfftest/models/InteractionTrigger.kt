package com.studiobff.studiobfftest.models

import kotlinx.serialization.Serializable
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Setting
import java.time.Instant

@Serializable
@Setting(settingPath = "settings/flowAnalyzer.json")
@Document(indexName = "interactiontriggerindex")
data class InteractionTrigger (

    @Id
    private val id: String,

    @Field(type = FieldType.Keyword, name = "account_id")
    private val accountId: String,

    @Field(type = FieldType.Keyword, name = "channel")
    private val channel: String,

    @Field(type = FieldType.Text, name = "phone_number", analyzer = "custom_analyzer_number")
    private val phoneNumber: String,

    @Field(type = FieldType.Keyword, name = "phone_number_id")
    private val phoneNumberId: String,

    @Field(type = FieldType.Text, name = "friendly_name")
    private val friendlyName: String,

    @Field(type = FieldType.Keyword, name = "flow_id")
    private val flowId: String,

    @Field(type = FieldType.Text, name = "flow_name", analyzer = "custom_analyzer")
    private val flowName: String,

    //@Field(type = FieldType.Date, pattern = ["yyyy-MM-dd'T'HH:mm:ss.SSSZZ"])
    //private val updated_at: Instant
    )