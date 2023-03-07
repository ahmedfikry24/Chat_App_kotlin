package com.example.chatapp.ui.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var email = ""
    var password = ""

    var emailError: String? = ""
    var passwordError: String? = ""

    fun login(){
        if (!validate()) return
    }

    fun validate(): Boolean {
        var valid = true

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