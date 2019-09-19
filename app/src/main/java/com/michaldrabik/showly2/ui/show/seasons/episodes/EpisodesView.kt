package com.michaldrabik.showly2.ui.show.seasons.episodes

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.michaldrabik.showly2.R
import com.michaldrabik.showly2.model.Episode
import com.michaldrabik.showly2.model.Season
import com.michaldrabik.showly2.utilities.extensions.visibleIf
import kotlinx.android.synthetic.main.view_episodes.view.*

class EpisodesView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  private val episodesAdapter by lazy { EpisodesAdapter() }

  init {
    inflate(context, R.layout.view_episodes, this)
    layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    setupRecycler()
  }

  fun bind(season: Season) {
    episodesAdapter.clearItems()
    episodesTitle.text = context.getString(R.string.textSeason, season.number)
    episodesOverview.text = season.overview
    episodesOverview.visibleIf(season.overview.isNotBlank())
  }

  fun bindEpisodes(episodes: List<Episode>) {
    episodesAdapter.setItems(episodes)
    episodesRecycler.scheduleLayoutAnimation()
  }

  private fun setupRecycler() {
    episodesRecycler.apply {
      setHasFixedSize(true)
      adapter = episodesAdapter
      layoutManager = LinearLayoutManager(context, VERTICAL, false)
      addItemDecoration(DividerItemDecoration(context, VERTICAL).apply {
        setDrawable(ContextCompat.getDrawable(context, R.drawable.divider_episodes)!!)
      })
    }
    episodesAdapter.itemClickListener = { }
  }
}