package com.route.islami_42.ui.home.tabs.hadeth_tab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami_42.databinding.ItemHadethBinding
import com.route.islami_42.models.HadethDM

class AhadethAdapter(var ahadethList: ArrayList<HadethDM>, var onItemClick: (HadethDM) -> Unit) :
    Adapter<AhadethAdapter.HadethViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val binding = ItemHadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HadethViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val hadeth = ahadethList[position]
        holder.binding.root.setOnClickListener {
            onItemClick(hadeth)
        }
        holder.binding.hadethTitle.text = hadeth.title
        holder.binding.hadethContent.text = hadeth.content

    }

    override fun getItemCount(): Int = ahadethList.size
    class HadethViewHolder(val binding: ItemHadethBinding) : ViewHolder(binding.root)
}