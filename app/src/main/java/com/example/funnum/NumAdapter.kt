package com.example.funnum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NumAdapter(val numList: MutableList<String>) : RecyclerView.Adapter<NumAdapter.NumViewHolder>(){

    class NumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numText: TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            numText = view.findViewById(R.id.numInfo)
        }
    }

    fun addItem(item: String) {
        numList.add(item)
        notifyItemInserted(numList.size - 1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_layout, parent, false)

        return NumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return numList.size
    }

    override fun onBindViewHolder(holder: NumAdapter.NumViewHolder, position: Int) {
        holder.numText.text =numList[position]
    }

}