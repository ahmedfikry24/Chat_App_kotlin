package com.example.chatapp.ui.login

import android.util.Log
import com.example.chatapp.utils.BaseViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : BaseViewModel() {
    var email = ""
    var password = ""

    var emailError: String? = null
    var passwordError: String? = null

    val auth : FirebaseAuth= Firebase.auth

    var navigator : NavigatorLogin? = null

    fun login(){
        if (validate()) return
        isLoading.value = true
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            isLoading.value = false
            if (it.isSuccessful){
                dialogMessage.value = "Successfully"
                navigator?.navigateToHome()

            }else{

                dialogMessage.value = it.exception?.message
            }
        }
    }

    fun validate(): Boolean {
        var valid = false

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