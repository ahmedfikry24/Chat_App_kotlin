package com.example.chatapp.ui.register

import android.util.Log
import com.example.chatapp.utils.BaseViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterViewModel : BaseViewModel() {
    var firstName = ""
    var lastName = ""
    var email = ""
    var password = ""

    var firstNameError: String? = ""
    var lastNameError: String? = ""
    var emailError: String? = ""
    var passwordError: String? = ""

    val auth: FirebaseAuth = Firebase.auth

    fun register() {
        if (validate()) return
        isLoading.value = true
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            isLoading.value = false
            if (it.isSuccessful) {
                dialogMessage.value = "Successfully"
                Log.e("register", "complete")
            } else {
                dialogMessage.value = it.exception?.message
                Log.e("register", it.exception?.message.toString())

            }
        }

    }

    fun validate(): Boolean {
        var valid = false
        if (firstName.isBlank()) {
            valid = true
            firstNameError = "this field required"
            return valid
        } else {
            firstNameError = null
        }

        if (lastName.isBlank()) {
            valid = true
            lastNameError = "this field required"
            return valid
        } else {
            lastNameError = null
        }

        if (email.isBlank()) {
            valid = true
            emailError = "this field required"
            return valid
        } else {
            emailError = null
        }

        if (password.isBlank()) {
            valid = true
            passwordError = "this field required"
            return valid
        } else {
            passwordError = null
        }

        return valid
    }

}