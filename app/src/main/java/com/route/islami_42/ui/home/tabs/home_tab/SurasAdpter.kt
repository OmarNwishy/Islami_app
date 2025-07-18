package com.route.islami_42.ui.home.tabs.home_tab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_42.databinding.ItemSuraBinding
import com.route.islami_42.models.SuraDM

class SurAdapter(val surasList: List<SuraDM>, val onSuraClick: (SuraDM) -> Unit) :
    RecyclerView.Adapter<SurAdapter.SuraViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): SuraViewHolder {
        return SuraViewHolder(
            ItemSuraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: SuraViewHolder, position: Int
    ) {
        holder.bind(surasList[position])
    }

    override fun getItemCount(): Int {
        return surasList.size
    }

    inner class SuraViewHolder(val binding: ItemSuraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sura: SuraDM) {
            binding.root.setOnClickListener {
                onSuraClick(sura)
            }
            binding.tvSuraAyaNumber.text = sura.numberOfAyahs
            binding.tvSuraArabicTitle.text = sura.nameAr
            binding.tvSuraEnglishTitle.text = sura.nameEn
            binding.tvSuraNumber.text = sura.id
        }
    }
}