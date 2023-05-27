package com.vitorxbranco.tripnow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()
        setupButton()
    }

    private fun setupSpinner() {
        val genderOptions = arrayOf("Feminino", "Masculino", "Outro", "Prefiro não dizer")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genderOptions)
        spinner_gender.adapter = genderAdapter
    }

    private fun setupButton() {
        button_create_account.setOnClickListener {
            createAccount()
        }

    }

    private fun createAccount() {
        val user = User(
            spinner_gender.selectedItem as String,
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email.text.toString(),
            edit_text_phone_number.text.toString(),
            edit_text_password.text.toString()
        )

        val intent = Intent(this,ConfirmationActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }
}