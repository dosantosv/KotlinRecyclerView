package com.example.kotlinrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recyclerview

class MainActivity : AppCompatActivity() {

    private lateinit var liveAdapter: LiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSource()
    }

    private fun addDataSource() {

        val dataSource = DataSource.createDataSet()
        this.liveAdapter.setDataSet(dataSource)

    }

    private fun initRecyclerView() {

        this.liveAdapter = LiveAdapter()

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = this.liveAdapter

    }
}