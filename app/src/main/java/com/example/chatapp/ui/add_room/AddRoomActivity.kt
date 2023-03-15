package com.example.chatapp.ui.add_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityAddRoomBinding
import com.example.chatapp.utils.BaseActivity

class AddRoomActivity : BaseActivity<AddRoomViewModel ,ActivityAddRoomBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutId(): Int = R.layout.activity_add_room

    override fun viewModel(): AddRoomViewModel = ViewModelProvider(this)[AddRoomViewModel::class.java]

}