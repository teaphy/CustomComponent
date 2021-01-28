package com.teaphy.customcomponent.itemDecoration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teaphy.customcomponent.R
import com.teaphy.customcomponent.itemDecoration.adapter.SpaceItemDecorationAdapter
import com.teaphy.customcomponent.itemDecoration.decoration.GridItemDecoration
import com.teaphy.customcomponent.itemDecoration.decoration.LinearItemDecoration

class SpaceItemDecorationActivity : AppCompatActivity() {

    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var verticalRecyclerView: RecyclerView
    private lateinit var gridRecyclerView: RecyclerView

    private val listData = listOf<String>("A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "M")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_item_decoration)

        initView()
    }

    private fun initView() {
        horizontalRecyclerView = findViewById(R.id.horizontal_recycler_view)
        verticalRecyclerView = findViewById(R.id.vertical_recycler_view)
        gridRecyclerView = findViewById(R.id.grid_recycler_view)

        with(horizontalRecyclerView) {

            layoutManager = LinearLayoutManager(
                this@SpaceItemDecorationActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            addItemDecoration(LinearItemDecoration(48, 0))

            val ad = SpaceItemDecorationAdapter(R.layout.item_space_decoration_horizontal, listData)
            adapter = ad
        }

        with(verticalRecyclerView) {

            layoutManager = LinearLayoutManager(
                this@SpaceItemDecorationActivity,
                LinearLayoutManager.VERTICAL,
                false
            )

            addItemDecoration(LinearItemDecoration(48, 48))

            val ad = SpaceItemDecorationAdapter(R.layout.item_space_decoration_vertical, listData)
            adapter = ad
        }

        with(gridRecyclerView) {

            layoutManager = GridLayoutManager(this@SpaceItemDecorationActivity, 3)
            val ad = SpaceItemDecorationAdapter(R.layout.item_space_decoration_grid, listData)
            adapter = ad

            addItemDecoration(GridItemDecoration(48, 48, 3))

        }
    }
}