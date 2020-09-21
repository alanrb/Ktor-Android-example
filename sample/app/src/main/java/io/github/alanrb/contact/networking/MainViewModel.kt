package io.github.alanrb.contact.networking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.alanrb.contact.networking.dto.User
import io.ktor.util.*
import kotlinx.coroutines.launch

/**
 * Created by Tuong (Alan) on 9/21/20.
 * Copyright (c) 2020 Buuuk. All rights reserved.
 */

@KtorExperimentalAPI
class MainViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>()

    init {
        viewModelScope.launch {
            users.value = APIs.randomUser()
        }
    }

}