package com.example.chatapp.ui.login

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityLoginBinding
import com.example.chatapp.ui.home.HomeActivity
import com.example.chatapp.ui.register.RegisterActivity
import com.example.chatapp.utils.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(), NavigatorLogin {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        viewModel.navigator = this
        initListeners()
        observeViewModel()
    }

    override fun getLayoutId(): Int = R.layout.activity_login
    override fun viewModel(): LoginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

    private fun initListeners() {
        binding.register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

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

    override fun navigateToHome() {
        val intent = Intent(this@LoginActivity , HomeActivity::class.java)
        startActivity(intent)
    }
}
