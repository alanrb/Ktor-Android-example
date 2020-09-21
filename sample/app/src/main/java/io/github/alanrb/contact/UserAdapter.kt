package io.github.alanrb.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.alanrb.contact.networking.dto.User
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by Tuong (Alan) on 9/21/20.
 * Copyright (c) 2020 Buuuk. All rights reserved.
 */

class UserAdapter(var items: List<User> = listOf()) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class UserViewHolder(
        parent: ViewGroup,
        private val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_user,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(rootView) {

        fun bind(user: User) {

            rootView.apply {
                tvName.text = "${user.name.title}.${user.name.first} ${user.name.last}"
                tvMobile.text = user.phone
            }
        }
    }
}