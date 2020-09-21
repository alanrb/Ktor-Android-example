package io.github.alanrb.contact.networking.dto

/**
 * Created by Tuong (Alan) on 9/21/20.
 * Copyright (c) 2020 Buuuk. All rights reserved.
 */

data class ContactResult(
    val results: List<User> = listOf()
)

data class User(
    val gender: String,
    val phone: String,
    val email: String,
    val name: Name
) {
    data class Name(
        val title: String,
        val first: String,
        val last: String
    )
}