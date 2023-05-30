package com.vitorxbranco.tripnow.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vitorxbranco.tripnow.R
import com.vitorxbranco.tripnow.data.User
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : AppCompatActivity() {

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        tv_user_full_name.text = user.getFullName()
        tv_user_email.text = user.email
        tv_user_phone_number.text = user.phoneNumber
    }

    private fun setupClickListeners() {
        tv_user_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        tv_user_phone_number.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phoneNumber}")
            startActivity(intent)
        }
    }
}