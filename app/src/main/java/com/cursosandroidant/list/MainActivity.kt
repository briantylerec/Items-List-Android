package com.cursosandroidant.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursosandroidant.list.databinding.ActivityMainBinding
import com.cursosandroidant.list.pojos.ItemEntity
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()
        setupButton()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.items.observe(this, { items ->
            adapter.submitList(items)
        })

        mainViewModel.errorMsg.observe(this, { error ->
            Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
        })
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter(this)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun setupButton(){
        binding.btnSave.setOnClickListener {
            val itemEntity = ItemEntity(Random.nextLong(), binding.etText.text.toString())
            mainViewModel.addItem(itemEntity)
        }
    }

    override fun onClick(itemEntity: ItemEntity) {
        mainViewModel.updateItem(itemEntity)
    }
}