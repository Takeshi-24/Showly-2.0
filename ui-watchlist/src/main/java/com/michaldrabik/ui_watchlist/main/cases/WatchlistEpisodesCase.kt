package com.michaldrabik.ui_watchlist.main.cases

import android.content.Context
import com.michaldrabik.common.di.AppScope
import com.michaldrabik.ui_base.trakt.quicksync.QuickSyncManager
import com.michaldrabik.ui_model.EpisodeBundle
import com.michaldrabik.ui_watchlist.WatchlistItem
import javax.inject.Inject

@AppScope
class WatchlistEpisodesCase @Inject constructor(
  private val episodesManager: com.michaldrabik.ui_episodes.EpisodesManager,
  private val quickSyncManager: QuickSyncManager
) {

  suspend fun setEpisodeWatched(context: Context, item: WatchlistItem) {
    val bundle = EpisodeBundle(item.episode, item.season, item.show)
    episodesManager.setEpisodeWatched(bundle)
    quickSyncManager.scheduleEpisodes(context, listOf(item.episode.ids.trakt.id))
  }
}
