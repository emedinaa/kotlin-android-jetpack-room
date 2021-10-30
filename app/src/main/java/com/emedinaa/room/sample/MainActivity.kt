package com.emedinaa.room.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.emedinaa.room.sample.data.ResourceDataSource
import com.emedinaa.room.sample.data.db.GithubResourceDatabase
import com.emedinaa.room.sample.model.GithubResource
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

/**
 * @author Eduardo Medina
 */
class MainActivity : AppCompatActivity() {

    private val repository by lazy {
        ResourceDataSource(GithubResourceDatabase.getInstance(applicationContext).resourceDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
    }

    //TODO refactor
    private fun addResource() {
        lifecycleScope.launch {
            repository.addResource(
                GithubResource(
                    0,
                    "Eduardo Medina",
                    "https://github.com/emedinaa/",
                    "https://avatars.githubusercontent.com/u/300238?s=64&v=4"
                )
            )
        }
    }

    private fun setupUi() {
        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            addResource()
        }
    }
}