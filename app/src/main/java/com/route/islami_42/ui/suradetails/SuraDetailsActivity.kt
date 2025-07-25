package com.route.islami_42.ui.suradetails

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.route.islami_42.databinding.ActivitySuraDetailsBinding
import com.route.islami_42.models.SuraDM
import com.route.islami_42.utils.Constants

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySuraDetailsBinding

    lateinit var sura: SuraDM

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadSuraData()

    }

    private fun loadSuraData() {

        sura = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.SURA_DETAILS_KEY, SuraDM::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Constants.SURA_DETAILS_KEY)!!
        }

        val inputStream = assets.open("quran/${sura.id}.txt")
        val data =inputStream.bufferedReader().readText()

        val listOfAyat = data.trim().split("\n").toMutableList()
        var suraText = ""
        for(i in 0..(listOfAyat.size-1)){
            listOfAyat[i] = "[$i] ${listOfAyat[i]}"
            suraText = "$suraText${listOfAyat[i]}"
        }

        bindScreenData(suraText)
    }




    private fun bindScreenData(suraText: String) {
        binding.tvAppBarTitle.text = sura.nameEn
        binding.tvSuraArabicTitle.text = sura.nameAr
        binding.tvSuraText.text = suraText
        binding.icBack.setOnClickListener {
            finish()
        }
    }
}
