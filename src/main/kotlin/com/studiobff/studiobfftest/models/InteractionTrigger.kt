package com.studiobff.studiobfftest.models

import org.joda.time.DateTime
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.DateFormat
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.LocalDateTime

@Document(indexName = "interactiontriggerindex")
data class InteractionTrigger (

    @Id
    private val id: String,

    @Field(type = FieldType.Keyword, name = "channel")
    private val channel: String,

    //touchpoint
    @Field(type = FieldType.Text, name = "phone_number")
    private val phoneNumber: String,

    @Field(type = FieldType.Text, name = "friendly_name")
    private val friendlyName: String,

    //ResourceName
    @Field(type = FieldType.Text, name = "flow_name")
    private val flowName: String

    //@Field(type = FieldType.Date, name = "updated_at", pattern=["uuuu-MM-dd'T'HH:mm:ss.SSSXXX"], format = [DateFormat.date_time])
    //private val updated_at: LocalDateTime UTC
    )