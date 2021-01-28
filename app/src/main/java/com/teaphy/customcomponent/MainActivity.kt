package com.teaphy.customcomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.teaphy.customcomponent.itemDecoration.ui.ItemDecorationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoItemDecoration(view: View) {
        startActivity(Intent(this, ItemDecorationActivity::class.java))
    }
}