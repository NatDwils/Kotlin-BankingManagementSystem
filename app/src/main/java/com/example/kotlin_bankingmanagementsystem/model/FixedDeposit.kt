package com.example.kotlin_bankingmanagementsystem.model

import java.util.*

data class FixedDeposit(
    val interest:Double,
    val tenure:Int,
    val depositBalance:Double,
    val fd_id: UUID = UUID.randomUUID(),
    val user_id:UUID
)