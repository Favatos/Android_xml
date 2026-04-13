package com.example.android_xml.feature.list.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_xml.databinding.ListActivityBinding
import kotlin.getValue

class ListActivity : AppCompatActivity() {

    lateinit var binding : ListActivityBinding
    private lateinit var adapter: CarAdapter
    private val viewModel : ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CarAdapter(viewModel.allCars)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}