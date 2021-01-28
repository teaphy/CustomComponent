package com.teaphy.customcomponent.itemDecoration.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.teaphy.customcomponent.R

class ItemDecorationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_decoration)
    }

    fun gotoSpaceItemDecoration(view: View) {
        startActivity(Intent(this, SpaceItemDecorationActivity::class.java))
    }
}