package com.example.chatapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityHomeBinding
import com.example.chatapp.utils.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel,ActivityHomeBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun viewModel(): HomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

}