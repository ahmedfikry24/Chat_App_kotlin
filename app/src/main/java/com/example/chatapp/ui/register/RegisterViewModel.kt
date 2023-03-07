package com.example.chatapp.ui.register

import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var firstName = ""
    var lastName = ""
    var email = ""
    var password = ""

    var firstNameError: String? = ""
    var lastNameError: String? = ""
    var emailError: String? = ""
    var passwordError: String? = ""

    fun register() {
        if (!validate()) return

    }

    fun validate(): Boolean {
        var valid = true
        if (firstName.isBlank()) {
            valid = false
            firstNameError = "this field required"
            return valid
        } else {
            firstNameError = null
        }

        if (lastName.isBlank()) {
            valid = false
            lastNameError = "this field required"
            return valid
        } else {
            lastNameError = null
        }

        if (email.isBlank()) {
            valid = false
            emailError = "this field required"
            return valid
        } else {
            emailError = null
        }

        if (password.isBlank()) {
            valid = false
            passwordError = "this field required"
            return valid
        } else {
            passwordError = null
        }

        return valid
    }
}