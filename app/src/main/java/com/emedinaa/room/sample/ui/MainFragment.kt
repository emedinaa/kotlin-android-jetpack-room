package com.emedinaa.room.sample.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.room.sample.R
import com.emedinaa.room.sample.data.ResourceDataSource
import com.emedinaa.room.sample.data.db.GithubResourceDatabase

/**
 * @author Eduardo Medina
 */
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(
            ResourceDataSource(
                GithubResourceDatabase.getInstance(requireContext().applicationContext)
                    .resourceDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = ResourceAdapter(emptyList()) {
            Toast.makeText(requireContext(), "item : $it", Toast.LENGTH_LONG).show()
            openBrowser(it.url)
        }
    }

    //https://developer.android.com/guide/components/intents-common#Browser
    private fun openBrowser(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }

    private fun setObservers() {
        viewModel.resources.observe(viewLifecycleOwner) { resources ->
            (view?.findViewById<RecyclerView>(R.id.recyclerView)?.adapter as ResourceAdapter).update(
                resources
            )
        }
    }

}