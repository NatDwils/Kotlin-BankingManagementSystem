package com.example.kotlin_bankingmanagementsystem.Functionalities

import com.example.kotlin_bankingmanagementsystem.*
import com.example.kotlin_bankingmanagementsystem.Utill.isEmailValid
import com.example.kotlin_bankingmanagementsystem.Utill.isPhoneNumberValid
import com.example.kotlin_bankingmanagementsystem.Utill.isStrongPassword
import com.example.kotlin_bankingmanagementsystem.model.User
import com.example.kotlin_bankingmanagementsystem.Menus.*

fun login(){
    println("Enter your Email : ")
    val email = readLine()!! // read user input as a string
    if (!isEmailValid(email)) {
        println("Email is not valid")
        menu()
    }
    println("Enter your Password : ")
    val password = readln()

    val user = users.find { it.email==email && it.password==password }

    if (user != null) {
        if(user.isAdmin){
            println("User Login Successfully 😁")
            adminMenu(user)
        }
        println("User Login Successfully 😁")
        userMenu(user)

    }
    println("Invalid User and Password !")
    menu()
}

fun register(){
    println("Enter your full name : ")
    val name = readln()
    println("Enter your phone number: ")
    val phoneNumber = readLine()!! // read user input as a string
    if (!isPhoneNumberValid(phoneNumber)) {
        println("Phone number is not valid")
        menu()
    }
    println("Enter your email address: ")
    val email = readLine()!! // read user input as a string
    if (!isEmailValid(email)) {
        println("Email is not valid")
        menu()
    }
    println("Enter your Password : ")
    val password = readln()
    if (isStrongPassword(password)){
        println("Give a strong password")
        menu()
    }
    println("Are you admin ?(y/n) ")
    val isAdmin = readln().toLowerCase() == "y"

    val user = User(name = name, phone = phoneNumber, email = email, password = password, isAdmin = isAdmin)

    users.add(user)
    saveUsers()
    println("User successfully registered 😁")
    menu()
}

fun logout(){
    println("User Logout Successfully 😁")
    menu()
}