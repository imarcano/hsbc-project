package com.inbergmarcano.mycvapp.ui.experience.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.ui.experience.model.Experience


class ExperienceAdapter(
    private val context: Context,
    private val list: MutableList<Experience>
): RecyclerView.Adapter<ExperienceAdapter.ListViewHolder>() {
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val experience = list[position]
        holder.company.text = experience.company
        holder.projectOrCustomer.text = experience.projectOrCustomer
        holder.role.text = experience.role
        holder.period.text = experience.period
        holder.completedTasks.text = experience.completedTasks
        holder.usedTools.text = experience.usedTools
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_experience, parent, false)
        return ListViewHolder(
            itemView
        )
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var layout: LinearLayout = itemView.findViewById(R.id.item_layout)
        val company: TextView = itemView.findViewById(R.id.item_company)
        val projectOrCustomer: TextView = itemView.findViewById(R.id.item_proyect_or_customer)
        val role: TextView = itemView.findViewById(R.id.item_role)
        val period: TextView = itemView.findViewById(R.id.item_period)
        val completedTasks: TextView = itemView.findViewById(R.id.item_completed_tasks)
        val usedTools: TextView = itemView.findViewById(R.id.item_used_tools)
    }

}