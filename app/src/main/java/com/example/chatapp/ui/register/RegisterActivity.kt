package com.example.chatapp.ui.register

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityRegisterBinding
import com.example.chatapp.ui.login.LoginActivity
import com.example.chatapp.utils.BaseActivity

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>() , NavigatorRegister {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        viewModel.navigator = this
        observeViewModel()
        initListeners()
    }

    override fun getLayoutId(): Int = R.layout.activity_register
    override fun viewModel(): RegisterViewModel =
        ViewModelProvider(this)[RegisterViewModel::class.java]

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }
        viewModel.dialogMessage.observe(this) {
            showDialog(
                title = "Alert", message = it,
                posButtonTitle = "ok",
                posButtonOnclick = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        p0?.dismiss()
                    }

                }
            )
        }
    }

    private fun initListeners() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    override fun navigateToLogin() {
        val intent = Intent(this@RegisterActivity , LoginActivity::class.java)
        startActivity(intent)
    }
}