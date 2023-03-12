package com.example.chatapp.utils

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding> : AppCompatActivity() {
    lateinit var viewModel: VM
    lateinit var binding: B
    var progressDialog = ProgressDialog(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    abstract fun getLayoutId(): Int
    abstract fun viewModel(): VM

    fun showLoading(){
       progressDialog.setTitle("Loading")
        progressDialog.show()
    }

    fun hideLoading(){
        progressDialog.hide()
    }
}