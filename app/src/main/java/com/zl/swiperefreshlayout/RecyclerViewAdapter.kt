package com.zl.swiperefreshlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(context: Context?, listData: List<Int?>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var listData: List<Int> = ArrayList()
    private var context: Context? = null

    init {
        this.context = context
        this.listData = listData as List<Int>
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = "第"+listData.get(position)+"条"

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textView:TextView
        init {
            textView = itemView.findViewById(R.id.textItem)
        }

    }

}


