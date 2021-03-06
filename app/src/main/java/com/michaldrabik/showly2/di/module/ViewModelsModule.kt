package com.michaldrabik.showly2.di.module

import androidx.lifecycle.ViewModel
import com.michaldrabik.showly2.di.ViewModelKey
import com.michaldrabik.showly2.ui.main.MainViewModel
import com.michaldrabik.ui_discover.DiscoverViewModel
import com.michaldrabik.ui_episodes.details.EpisodeDetailsViewModel
import com.michaldrabik.ui_my_shows.archive.ArchiveViewModel
import com.michaldrabik.ui_my_shows.main.FollowedShowsViewModel
import com.michaldrabik.ui_my_shows.myshows.MyShowsViewModel
import com.michaldrabik.ui_my_shows.seelater.SeeLaterViewModel
import com.michaldrabik.ui_search.SearchViewModel
import com.michaldrabik.ui_settings.SettingsViewModel
import com.michaldrabik.ui_show.ShowDetailsViewModel
import com.michaldrabik.ui_show.gallery.FanartGalleryViewModel
import com.michaldrabik.ui_statistics.StatisticsViewModel
import com.michaldrabik.ui_trakt_sync.TraktSyncViewModel
import com.michaldrabik.ui_watchlist.main.WatchlistViewModel
import com.michaldrabik.ui_watchlist.upcoming.WatchlistUpcomingViewModel
import com.michaldrabik.ui_watchlist.watchlist.WatchlistMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelsModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SettingsViewModel::class)
  abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(DiscoverViewModel::class)
  abstract fun bindDiscoverViewModel(viewModel: DiscoverViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(EpisodeDetailsViewModel::class)
  abstract fun bindEpisodeDetailsViewModel(viewModel: EpisodeDetailsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(FanartGalleryViewModel::class)
  abstract fun bindFanartGalleryViewModel(viewModel: FanartGalleryViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(MyShowsViewModel::class)
  abstract fun bindMyShowsViewModel(viewModel: MyShowsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SearchViewModel::class)
  abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SeeLaterViewModel::class)
  abstract fun bindSeeLaterViewModel(viewModel: SeeLaterViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(ArchiveViewModel::class)
  abstract fun bindArchiveViewModel(viewModel: ArchiveViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(ShowDetailsViewModel::class)
  abstract fun bindShowDetailsViewModel(viewModel: ShowDetailsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(WatchlistViewModel::class)
  abstract fun bindWatchlistMainViewModel(viewModel: WatchlistViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(WatchlistMainViewModel::class)
  abstract fun bindWatchlistViewModel(viewModel: WatchlistMainViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(WatchlistUpcomingViewModel::class)
  abstract fun bindWatchlistUpcomingViewModel(viewModel: WatchlistUpcomingViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(FollowedShowsViewModel::class)
  abstract fun bindFollowedShowsViewModel(viewModel: FollowedShowsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(TraktSyncViewModel::class)
  abstract fun bindTraktSyncViewModel(viewModel: TraktSyncViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(StatisticsViewModel::class)
  abstract fun bindStatisticsViewModel(viewModel: StatisticsViewModel): ViewModel
}
