package com.example.kotlin_bankingmanagementsystem.Utill

fun isEmailValid(email: String): Boolean {
    val regex = Regex("^([\\w\\d!#$%&'*+/=?^_`{|}~-]+(\\.[\\w\\d!#$%&'*+/=?^_`{|}~-]+)*)@[\\w\\d-]+(\\.[\\w\\d-]+)*(\\.[\\w]{2,})$")
    return regex.matches(email)
}


fun isPhoneNumberValid(phoneNumber: String): Boolean {
    val phoneRegex = Regex("^\\+(?:[0-9] ?){6,14}[0-9]\$")
    return phoneRegex.matches(phoneNumber)
}

fun isStrongPassword(password: String): Boolean {
    val upperCaseRegex = Regex("[A-Z]")
    val lowerCaseRegex = Regex("[a-z]")
    val digitRegex = Regex("\\d")
    val specialCharRegex = Regex("[^A-Za-z0-9]")

    return password.length >= 8 &&
            upperCaseRegex.containsMatchIn(password) &&
            lowerCaseRegex.containsMatchIn(password) &&
            digitRegex.containsMatchIn(password) &&
            specialCharRegex.containsMatchIn(password)
}