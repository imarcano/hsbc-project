package com.inbergmarcano.mycvapp.ui.basicinformation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import com.inbergmarcano.mycvapp.ui.profile.model.Profile


class BasicInformationAdapter(
    private val context: Context,
    private val list: MutableList<BasicInformation>
): RecyclerView.Adapter<BasicInformationAdapter.ListViewHolder>() {
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val basicInformation = list[position]
        holder.title!!.text = basicInformation.title
        holder.body!!.text = basicInformation.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_basic_information, parent, false)
        return ListViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var layout: LinearLayout = itemView.findViewById(R.id.item_layout)
        val title: TextView = itemView.findViewById(R.id.item_title)
        val body: TextView = itemView.findViewById(R.id.item_body)
    }

}