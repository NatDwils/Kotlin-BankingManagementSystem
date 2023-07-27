package com.example.kotlin_bankingmanagementsystem.model

import java.util.*

data class User(
    val user_id:UUID= UUID.randomUUID(),
    var name: String,
    var phone: String,
    val email: String,
    var password:String,
    val isAdmin:Boolean=false,
    val accounts: MutableList<Account> = mutableListOf(),
    var isActive:Boolean=true
)