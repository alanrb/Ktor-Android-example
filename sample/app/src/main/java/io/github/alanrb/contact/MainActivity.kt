package io.github.alanrb.contact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.alanrb.contact.networking.MainViewModel
import io.ktor.util.*
import kotlinx.android.synthetic.main.activity_main.*

@KtorExperimentalAPI
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.users.observe(this, { users ->
            userAdapter.items = users
            userAdapter.notifyDataSetChanged()
        })

        with(rvUser) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}