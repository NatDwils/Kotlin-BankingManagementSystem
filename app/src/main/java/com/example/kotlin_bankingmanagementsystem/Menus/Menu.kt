package com.example.kotlin_bankingmanagementsystem.Menus

import com.example.kotlin_bankingmanagementsystem.Functionalities.*
import com.example.kotlin_bankingmanagementsystem.model.User
import kotlin.system.exitProcess

fun menu(){
    println("--! Hello Welcome to Banking Management System !--")
    println("1-> Login")
    println("2-> Register")
    println("3-> Exit")
    val choice= readln().toInt()

    when(choice){
        1-> login()
        2-> register()
        3-> exitProcess(0)
        else->{println("Invalid choice")
            menu()}
    }
}


fun adminMenu(user: User){
    println("--ADMIN MENU--")
    println("1-> User Management")
    println("2-> Account Management")
    println("3-> Logout")
    println("4-> Exit")

    val choice= readln().toInt()

    when(choice){
        1-> userManagement(user)
        2-> accountManagement(user)
        3-> logout()
        4->exitProcess(0)
        else-> {
            println("Invalid choice")
            adminMenu(user)
        }
    }
}


fun userMenu(user: User){
    println("--USER MENU--")
    println("1-> Open Bank Account")
    println("2-> View Account Details")
    println("3-> Update Profile")
    println("4-> Withdraw Money")
    println("5-> Deposit Money")
    println("6-> Fixed Deposit")
    println("7-> Transfer")
    println("8-> View Fixed Deposit")
    println("9-> View Transactions")
    println("10-> Logout")
    println("11-> Exit")

    when(readln().toInt()){
        1-> OpnBankAcc(user)
        2-> ViewAccount(user)
        3-> updateProfile(user)
        4-> Withdraw(user)
        5-> Deposit(user)
        6-> fixedDepositUser(user)
        7-> transfer(user)
        8-> viewFDUser(user)
        9-> viewTransactionsUser(user)
        10->logout()
        11->exitProcess(0)
        else->{println("Invalid choice")
            userMenu(user)
        }
    }
}

fun userManagement(user: User){
    println("1-> USER DETAILS")
    println("2-> UPDATE USER DETAILS")
    println("3-> DEACTIVATE USER")
    println("4-> View Fixed Deposit")
    println("5-> View Transactions")
    println("6: Exit")

    val choice= readln().toInt()

    when(choice){
        1->userDetail(user)
        2->updateUserDetail()
        3->deactivateUser()
        4->viewFDAdmin(user)
        5->viewTransactionsAdmin(user)
        6->exitProcess(0)
        else->{println("Invalid choice")
            userManagement(user)
        }
    }
}



fun accountManagement(user: User){
    println("1-> View list of Accounts")
    println("2-> Open new account for an User")
    println("3-> Deactivate an account")
    println("4->View Account of an User")
    println("5-> Exit")

    val choice= readln().toInt()

    when(choice){
        1->viewAccountList(user)
        2->openAccount()
        3->deactivateAccount(user)
        4->viewAccount(user)
        5->exitProcess(0)
        else->{println("Invalid choice")
            accountManagement(user)
        }
    }
}
