package com.example.chatapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityLoginBinding
import com.example.chatapp.utils.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

    }

    override fun getLayoutId(): Int = R.layout.activity_login
    override fun viewModel(): LoginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
}