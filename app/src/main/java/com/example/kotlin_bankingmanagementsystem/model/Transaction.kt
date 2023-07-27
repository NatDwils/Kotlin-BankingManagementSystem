package com.example.kotlin_bankingmanagementsystem.model

import java.util.*

data class Transaction(
    val transaction_id: UUID = UUID.randomUUID(),
    val accountNumber: UUID,
    val transactionType:String,
    val amount: Double,
    val user_id:UUID
)