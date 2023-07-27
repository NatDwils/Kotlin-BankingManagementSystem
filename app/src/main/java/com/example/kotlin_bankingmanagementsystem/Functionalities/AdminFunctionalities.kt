package com.example.kotlin_bankingmanagementsystem.Functionalities

import com.example.kotlin_bankingmanagementsystem.*
import com.example.kotlin_bankingmanagementsystem.model.Account
import com.example.kotlin_bankingmanagementsystem.model.User
import com.example.kotlin_bankingmanagementsystem.Menus.*

fun userDetail(user: User) {
    users.forEach {
        println("User id : ${it.user_id}")
        println("Name : ${it.name}")
        println("Phone Number : ${it.phone}")
        println("Email : ${it.email}")
        println("Accounts :")
        it.accounts.forEach {
            println("Account Number : ${it.accountNumber}")
            println("Balance : ${it.balance}")
        }

    }
    userManagement(user)
}

fun updateUserDetail() {
    println("Enter email address of the user :")
    val email = readln()
    val user = users.find { it.email == email }

    if (user == null) {
        println("User with email $email not found.")
        return
    }

    println("Current name: ${user.name}")
    print("Enter new Name (leave blank to keep current value): ")
    val newName = readLine()!!
    user.name = if (newName.isNotEmpty()) newName else user.name

    println("Current phone number: ${user.phone}")
    print("Enter new phone number (leave blank to keep current value): ")
    val newPhone = readLine()!!
    user.phone = if (newPhone.isNotEmpty()) newPhone else user.phone
    println("Details updated successfully.")

    saveUsers()
    userManagement(user)
}

fun deactivateUser() {
    println("Enter Email of User : ")
    val email = readln()
    val user = users.find { it.email == email }
    if (user != null) {
        user.isActive = false
        println("User Successfully Deactive !")
        saveUsers()
        userManagement(user)
    }
}

fun viewAccountList(user: User) {
    users.forEach { user ->
        user.accounts.forEach {
            println("User_id : ${user.user_id}")
            println("Account Number : ${it.accountNumber}")
            println("Balance : ${it.balance}")

        }
    }
    accountManagement(user)

}

fun openAccount() {

    println("Enter Email of user : ")
    val email = readln()
    val user = users.find { it.email == email }
    if (user != null) {
        println("Enter type of account(Saving / Current ) : ")
        val type = readln().trim()
        println("Enter Initial Deposit : ")
        val initialDeposit = readln().trim().toDouble()
        val account = Account(type = type, balance = initialDeposit, user_id = user.user_id)
        user.accounts.add(account)
        println("Account successfully created !")
        println("Account Number : ${account.accountNumber}")
        println("Current Balance : ${account.balance}")
        saveUsers()
        accountManagement(user)
    }
}

fun deactivateAccount(user: User) {

    println("Enter Email of User : ")
    val email = readln()
    println("Enter Account Number of User : ")
    val accountNumber = readln()
    val user = users.find { user -> user.email == email }
    val account = user?.accounts?.find { it.accountNumber.toString() == accountNumber }
    if (account != null) {
        account.isActive = false
        println("Account Successfully Deactive !")
        saveUsers()
        accountManagement(user)
    }
}

fun viewAccount(user: User) {

    println("Enter Email of User : ")
    val email = readln()
    val u = users.find { user -> user.email == email }
    if (u != null) {
        u.accounts.forEach {
            println("User_id : ${user.user_id}")
            println("Type : ${it.type}")
            println("Account Number : ${it.accountNumber}")
            println("Balance : ${it.balance}")
        }
        saveUsers()
        accountManagement(user)
    }
}

fun viewFDAdmin(user: User){

    println("Enter Email of User : ")
    val email = readln()
    val u = users.find { user -> user.email == email }
    if (u != null) {
       val fd = fixedDeposit.filter { it.user_id == u.user_id }
        if(fd!=null){
            fd.forEach{
                println("interest: ${it.interest},\n" +
                        "tenure: ${it.tenure},\n" +
                        "depositBalance: ${it.depositBalance},\n" +
                        "fd_id: ${it.fd_id},\n"
                )
            }
        }else{
          println("No fixed deposit found for the user !")
        }
        }else{
            println("No user found !")
    }
        userManagement(user)
    }

fun viewTransactionsAdmin(user: User){
    println("Enter Email of User : ")
    val email = readln()
    val u = users.find { user -> user.email == email }
    if (u != null) {
        val transactions = transactions.filter { it.user_id == u.user_id }
        if(transactions!=null){
            transactions.forEach{
                println("transaction_id: ${it.transaction_id},\n" +
                        "accountNumber: ${it.accountNumber}" +
                        "transactionType: ${it.transactionType},\n" +
                        "amount: ${it.amount},\n"
                )
            }
        }else{
            println("No Transaction found for the user !")
        }
    }else{
        println("No user found !")
    }
    userManagement(user)


}