package com.route.islami_42.ui.hadeth_details

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami_42.databinding.ActivitySuraDetailsBinding
import com.route.islami_42.models.HadethDM
import com.route.islami_42.utils.Constants.Companion.HADETH_KEY

class HadethDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(
                HADETH_KEY,
                HadethDM::class.java
            )
        } else intent.getSerializableExtra(HADETH_KEY) as HadethDM

        binding.tvSuraText.text = hadeth!!.content
        binding.tvSuraArabicTitle.text = hadeth.title
        binding.icBack.setOnClickListener {
            finish()
        }
    }

}

