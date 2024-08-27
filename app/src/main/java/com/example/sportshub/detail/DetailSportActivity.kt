package com.example.sportshub.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.sportshub.R
import com.example.sportshub.core.domain.model.Sport
import com.example.sportshub.databinding.ActivityDetailSportBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSportActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailSportViewModel: DetailSportViewModel by viewModel()
    private lateinit var binding: ActivityDetailSportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailSport = intent.getParcelableExtra<Sport>(EXTRA_DATA)
        showDetailSport(detailSport)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showDetailSport(detailSport: Sport?) {
        detailSport?.let {
            supportActionBar?.title = detailSport.strTeam
            binding.categoryBadge.text = detailSport.strSport
            binding.fullName.text = detailSport.strTeam
            binding.subtitleText.text = "Founded in ${detailSport.intFormedYear}"
            binding.content.teamName.text = detailSport.strTeam
            binding.content.articleContent.text = detailSport.strDescriptionEN
            Glide.with(this@DetailSportActivity)
                .load(detailSport.strBadge)
                .into(binding.headerImage)

            var statusFavorite = detailSport.isFavorite
            setStatusFavorite(statusFavorite)
            binding.saveButton.setOnClickListener {
                statusFavorite = !statusFavorite
                detailSportViewModel.setFavoriteSport(detailSport, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.saveButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_bookmark_24))
        } else {
            binding.saveButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_bookmark_border_24))
        }
    }
}
