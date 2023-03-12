package com.example.chatapp.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("error")
fun textInputError(text : TextInputLayout , error : String?){
    text.error = error
}