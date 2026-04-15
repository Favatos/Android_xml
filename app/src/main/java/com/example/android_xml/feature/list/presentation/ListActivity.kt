package com.example.android_xml.feature.list.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_xml.databinding.ListActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity() {

    lateinit var binding : ListActivityBinding
    private lateinit var adapter: CarAdapter
    private val viewModel : ListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CarAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.cars.observe(this) {
            adapter.updateList(it)
        }

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}