package com.example.kotlinrecyclerview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinrecyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.recyclerview
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var liveAdapter: LiveAdapter
    private lateinit var _binding: ActivityMainBinding

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

        this.liveAdapter = LiveAdapter { live ->
            openLink(live.link)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = liveAdapter
        }



    }

    private fun openLink(url: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }
}