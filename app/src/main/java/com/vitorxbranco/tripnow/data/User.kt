package com.vitorxbranco.tripnow.data

data class User(
    val gender: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String
) : java.io.Serializable {

    fun getFullName() = "$firstName $lastName"
}
