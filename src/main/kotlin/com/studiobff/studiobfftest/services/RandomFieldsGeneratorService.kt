package com.studiobff.studiobfftest.services

import org.springframework.stereotype.Service

@Service
class RandomFieldsGeneratorService {

    fun generatePhoneNumber(): String{
        var phoneNumber = "+ "
        repeat(10) {
            phoneNumber += ('0'..'9').random()
        }

        return phoneNumber
    }

    fun generateRandomChannelType(): String{
        val channels = listOf<String>("SMS", "Call", "Email", "Live Chat")
        val  randomChannelIndex= (0..3).random()

        return channels[randomChannelIndex]
    }

    fun generateRandomFriendlyName(): String{
        return getRandomString(7)
    }

    fun generateRandomFlowName(): String{
        val flowName =  getRandomString(4)
        return "Flow name ${flowName}"
    }

    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}