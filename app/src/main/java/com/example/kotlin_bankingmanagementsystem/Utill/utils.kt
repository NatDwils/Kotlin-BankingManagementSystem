package com.example.kotlin_bankingmanagementsystem

import com.example.kotlin_bankingmanagementsystem.model.FixedDeposit
import com.example.kotlin_bankingmanagementsystem.model.Transaction
import com.example.kotlin_bankingmanagementsystem.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File


val gson: Gson = GsonBuilder().setPrettyPrinting().create()

val userFile = File("users.json")
var users: MutableList<User> = if (userFile.exists()) {
    val type = object : TypeToken<MutableList<User>>() {}.type
    gson.fromJson(userFile.readText(), type)
} else {
    mutableListOf()
}

val transactionFile = File("transaction.json")
var transactions: MutableList<Transaction> = if (transactionFile.exists()) {
    val type = object : TypeToken<MutableList<Transaction>>() {}.type
    gson.fromJson(transactionFile.readText(), type)
} else {
    mutableListOf()
}

val fixedDepositFile = File("fixedDeposit.json")
var fixedDeposit: MutableList<FixedDeposit> = if (fixedDepositFile.exists()) {
    val type = object : TypeToken<MutableList<FixedDeposit>>() {}.type
    gson.fromJson(fixedDepositFile.readText(), type)
} else {
    mutableListOf()

}

fun saveUsers() {    userFile.writeText(gson.toJson(users))}

fun saveTransaction() {    transactionFile.writeText(gson.toJson(transactions))}

fun saveFixedDeposit() {    fixedDepositFile.writeText(gson.toJson(fixedDeposit))}