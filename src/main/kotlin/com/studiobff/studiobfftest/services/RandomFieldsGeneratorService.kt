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

    // Generate no more than maxNoAccounts accounts, but can repeat since we can have more than one trigger
    // per account
    fun generateRandomAccount(maxNoAccounts: Int): String{
        val accountNo = (0 until maxNoAccounts).random()
        return "account-${1}"
    }

    // We can have more than one trigger with the same flow id
    fun generateRandomFlowId(maxNoTriggers: Int): String{
        val accountNo = (0 until maxNoTriggers).random()
        return "flow-id-${accountNo}"
    }
}