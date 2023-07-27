package com.example.kotlin_bankingmanagementsystem.Functionalities

import com.example.kotlin_bankingmanagementsystem.*
import com.example.kotlin_bankingmanagementsystem.model.Account
import com.example.kotlin_bankingmanagementsystem.model.FixedDeposit
import com.example.kotlin_bankingmanagementsystem.model.Transaction
import com.example.kotlin_bankingmanagementsystem.model.User
import com.example.kotlin_bankingmanagementsystem.saveUsers
import com.example.kotlin_bankingmanagementsystem.Menus.*


fun transfer(user: User) {
    user.accounts.forEach { account ->
        if (account.isActive) {

            println("Please enter the account number you would like to transfer from:")
            val fromAccountNumber = readLine()
            val fromAccount = user.accounts.find { it.accountNumber.toString() == fromAccountNumber }
            if (fromAccount != null) {

                println("Please enter the account number you would like to transfer to:")
                val toAccountNumber = readLine()

                val toAccount = users.flatMap { it.accounts }.find { it.accountNumber.toString() == toAccountNumber }
                if (toAccount != null) {

                    println("Please enter the amount you would like to transfer:")
                    val amountInput = readLine()?.toDoubleOrNull()
                    if (amountInput != null && amountInput > 0 && amountInput <= fromAccount.balance) {
                        fromAccount.balance -= amountInput
                        toAccount.balance += amountInput
                        val transaction = Transaction(accountNumber = fromAccount.accountNumber, transactionType = "transfer",amount = amountInput, user_id = user.user_id)
                        transactions.add(transaction)
                        saveTransaction()
                        saveUsers()
                        println ("Transfer successful.")
                        println("Current Balance in account : ${fromAccount.balance}")
                    } else {
                        println("Invalid input or insufficient funds. Please try again.")
                    }
                } else {
                    println("Destination account not found. Please try again.")
                }
            } else {
                println("Account not found. Please try again.")

            }
        } else {
            println("Account is Deactive")
        }
        userMenu(user)
    }
}

fun fixedDepositUser(user: User) {
    user.accounts.forEach { account ->
        if (account.isActive) {

            println("Enter the Account Number : ")
            val accontNumber = readln()
            var accountNum = user.accounts.find { it.accountNumber.toString() == accontNumber }
            if(accountNum != null) {
                println("Enter the Fixed Deposit Amount : ")
                val amount = readln().toDouble()
                if (amount < account.balance) {
                    println("Enter the Fixed Deposit tenure in months : ")
                    val tenure = readln().toInt()
                    val rate = 0.05
                    val interest = amount * rate * tenure / 12
                    val newAmount = amount + interest
                    account.balance -= amount
                    val FD = FixedDeposit(tenure = tenure, depositBalance = amount, interest = rate, user_id = user.user_id)
                    fixedDeposit.add(FD)
                    saveFixedDeposit()
                    println("Fixed deposit Successfull !")

                    println("interest: ${FD.interest},\n" +
                            "tenure: ${FD.tenure},\n" +
                            "depositBalance: ${FD.depositBalance},\n" +
                            "fd_id: ${FD.fd_id},\n"
                    )
                } else {
                    println("Insufficient Balance")
                }
            }

        }else{
        println("Account is Deactive")
        }
        userMenu(user)
    }
}

fun Deposit(user: User) {
    println("Enter Account Number : ")
    val accountnum= readLine()
    val account=user.accounts.find { it.accountNumber.toString() == accountnum }
    if (account != null) {
        if (account.isActive) {
            println("Amount you want to Deposit : ")
            val amount = readln().toDouble()
            if (amount <= 0.0) {
                println("Please enter valid deposit amount")
            }
            account.balance += amount
            println("your current balance : ${account.balance}")
            saveUsers()
        }else {
            println("Account is Deactive")
        }
    }
    userMenu(user)
}

fun Withdraw(user: User) {
    println("Enter Account Number : ")
    val accountnum= readLine()
    val account=user.accounts.find { it.accountNumber.toString() == accountnum }
    if (account != null) {
        if (account.isActive) {
            println("Amount you want to withdraw : ")
            val amount = readln().toDouble()
            if (amount > account.balance) {
                println("Don't have sufficient balance")
            } else if (amount <= 0.0) {
                println("Please enter valid withdrawal amount")
            }
            account.balance -= amount
            println("your current balance : ${account.balance}")
            saveUsers()
        }else {
            println("Account is de active")
        }
        userMenu(user)
    }
}

fun updateProfile(user: User) {
    print("Enter new Name (leave blank to keep current value): ")
    val newName = readLine()!!
    user.name = if (newName.isNotEmpty()) newName else user.name

    print("Enter new phone number (leave blank to keep current value): ")
    val newPhone = readLine()!!
    user.phone = if (newPhone.isNotEmpty()) newPhone else user.phone

    print("Enter new Password (leave blank to keep current value): ")
    val newPassword = readLine()!!
    user.password = if (newPassword.isNotEmpty()) newPassword else user.password

    println("Details updated successfully.")

    saveUsers()
    userMenu(user)
}

fun ViewAccount(user: User) {
    if (user != null) {
        user.accounts.forEach { account ->
            println("Account Number : ${account.accountNumber}")
            println("Type : ${account.type}")
            println("Balance : ${account.balance}")
            if (account.isActive) {
                println("Account is active")
            }else {
                println("Account frozen.")
            }
        }
        userMenu(user)
    }
}


fun OpnBankAcc(user: User) {

    if (user != null) {
        println("Enter type of account(Saving / Current ) : ")
        val type = readln().trim()
        println("Enter Initial Deposit : ")
        val initialDeposit = readln().trim().toDouble()
        val account = Account(type = type, balance = initialDeposit, user_id = user.user_id)
        user.accounts.add(account)
        saveUsers()
        println("Account Number: ${account.accountNumber}")
        println("Balance: ${account.balance}")
        userMenu(user)
    }
}


fun viewFDUser(user: User){
        if (user.isActive) {
            val fd = fixedDeposit.filter { it.user_id == user.user_id }
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
        }else {
            println("Account is Deactive")
        }

    userMenu(user)
}


fun viewTransactionsUser(user: User){
        if (user.isActive) {
            val transactions = transactions.filter { it.user_id == user.user_id }
            if(transactions!=null){
                transactions.forEach{
                    println("transaction_id: ${it.transaction_id},\n" +
                            "accountNumber: ${it.accountNumber}" +
                            "transactionType: ${it.transactionType},\n" +
                            "amount: ${it.amount},\n"
                    )
                }
            }else {
                println("No Transaction found for the user !")
            }
        }else {
            println("Account is Deactive")
        }
    userMenu(user)
}