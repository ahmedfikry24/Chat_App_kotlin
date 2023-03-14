package com.example.chatapp.utils

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.chatapp.R

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding> : AppCompatActivity() {
    lateinit var viewModel: VM
    lateinit var binding: B
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    abstract fun getLayoutId(): Int
    abstract fun viewModel(): VM

    fun showLoading() {
        progressDialog = ProgressDialog(this)
        progressDialog?.setTitle("Loading")
        progressDialog?.setCancelable(false)
        progressDialog?.show()
    }

    fun hideLoading() {
        progressDialog?.hide()
    }

    fun showDialog(
        title: String = "",
        message: String = "",
        posButtonTitle: String? = null,
        posButtonOnclick: DialogInterface.OnClickListener? = null,
        negButtonTitle: String? = null,
        negButtonOnclick: DialogInterface.OnClickListener? = null
    ) {

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setIcon(R.drawable.ic_loading)
        dialog.setPositiveButton(posButtonTitle, posButtonOnclick)
        dialog.setNegativeButton(negButtonTitle, negButtonOnclick)
        dialog.setNegativeButton(negButtonTitle,negButtonOnclick)
        dialog.show()

    }
}