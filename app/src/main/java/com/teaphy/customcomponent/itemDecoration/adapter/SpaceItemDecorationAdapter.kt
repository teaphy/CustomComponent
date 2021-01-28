package com.teaphy.customcomponent.itemDecoration.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.teaphy.customcomponent.R

/**
 * @Desc:
 * @author tiany
 * @time  2021-01-28  14:29
 * @version 1.0
 */
class SpaceItemDecorationAdapter(private val layoutRes: Int, private val listData: List<String>) :
    RecyclerView.Adapter<SpaceItemDecorationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = listData[position]
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
    }
}