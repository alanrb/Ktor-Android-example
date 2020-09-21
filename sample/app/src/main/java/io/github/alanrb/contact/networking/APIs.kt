package io.github.alanrb.contact.networking

import io.github.alanrb.contact.networking.dto.ContactResult
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.util.*

/**
 * Created by Tuong (Alan) on 9/21/20.
 * Copyright (c) 2020 Buuuk. All rights reserved.
 */

@KtorExperimentalAPI
object APIs {

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun randomUser() = client.get<ContactResult>("https://randomuser.me/api/?results=25") {
        headers {
            append("custom-header", "header-value")
        }
    }.results
}