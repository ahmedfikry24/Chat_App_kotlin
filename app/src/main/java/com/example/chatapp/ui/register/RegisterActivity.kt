package com.example.chatapp.ui.register

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityRegisterBinding
import com.example.chatapp.utils.BaseActivity

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        observeViewModel()
    }

    override fun getLayoutId(): Int = R.layout.activity_register
    override fun viewModel(): RegisterViewModel =
        ViewModelProvider(this)[RegisterViewModel::class.java]

    private fun observeViewModel(){
        viewModel.isLoading.observe(this){
            if (it){
                showLoading()
            }else{
                hideLoading()
            }
        }
    }
}