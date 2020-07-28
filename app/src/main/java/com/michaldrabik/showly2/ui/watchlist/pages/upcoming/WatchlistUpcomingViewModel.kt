package com.michaldrabik.showly2.ui.watchlist.pages.upcoming

import androidx.lifecycle.viewModelScope
import com.michaldrabik.showly2.model.Image
import com.michaldrabik.showly2.ui.common.base.BaseViewModel
import com.michaldrabik.showly2.ui.watchlist.WatchlistInteractor
import com.michaldrabik.showly2.ui.watchlist.WatchlistUiModel
import com.michaldrabik.showly2.ui.watchlist.pages.watchlist.recycler.WatchlistMainItem
import com.michaldrabik.showly2.utilities.extensions.findReplace
import kotlinx.coroutines.launch
import javax.inject.Inject

class WatchlistUpcomingViewModel @Inject constructor(
  private val interactor: WatchlistInteractor
) : BaseViewModel<WatchlistUpcomingUiModel>() {

  fun handleParentAction(model: WatchlistUiModel) {
    uiState = WatchlistUpcomingUiModel(items = model.items?.toList())
  }

  fun findMissingImage(item: WatchlistMainItem, force: Boolean) {

    fun updateItem(new: WatchlistMainItem) {
      val currentItems = uiState?.items?.toMutableList()
      currentItems?.findReplace(new) { it.isSameAs(new) }
      uiState = WatchlistUpcomingUiModel(items = currentItems)
    }

    viewModelScope.launch {
      updateItem(item.copy(isLoading = true))
      try {
        val image = interactor.loadMissingImage(item.show, item.image.type, force)
        updateItem(item.copy(image = image, isLoading = false))
      } catch (t: Throwable) {
        val unavailable = Image.createUnavailable(item.image.type)
        updateItem(item.copy(image = unavailable, isLoading = false))
      }
    }
  }
}
