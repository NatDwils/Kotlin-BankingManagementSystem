package com.example.kotlin_bankingmanagementsystem.model

import java.util.*

data class Account(
    val accountNumber: UUID = UUID.randomUUID(),
    var balance:Double,
    val type:String,
    var user_id : UUID,
    var isActive:Boolean=true
)