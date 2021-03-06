package com.michaldrabik.ui_repository.shows

import androidx.room.withTransaction
import com.michaldrabik.common.di.AppScope
import com.michaldrabik.common.extensions.nowUtcMillis
import com.michaldrabik.storage.database.AppDatabase
import com.michaldrabik.storage.database.model.ArchiveShow
import com.michaldrabik.ui_model.IdTrakt
import com.michaldrabik.ui_repository.mappers.Mappers
import javax.inject.Inject

@AppScope
class ArchiveShowsRepository @Inject constructor(
  private val database: AppDatabase,
  private val mappers: Mappers
) {

  suspend fun loadAll() =
    database.archiveShowsDao().getAll()
      .map { mappers.show.fromDatabase(it) }

  suspend fun loadAll(ids: List<IdTrakt>) =
    database.archiveShowsDao().getAll(ids.map { it.id })
      .map { mappers.show.fromDatabase(it) }

  suspend fun load(id: IdTrakt) =
    database.archiveShowsDao().getById(id.id)?.let {
      mappers.show.fromDatabase(it)
    }

  suspend fun loadAllIds() = database.archiveShowsDao().getAllTraktIds()

  suspend fun insert(id: IdTrakt) {
    val dbShow = ArchiveShow.fromTraktId(id.id, nowUtcMillis())
    database.run {
      withTransaction {
        archiveShowsDao().insert(dbShow)
        myShowsDao().deleteById(id.id)
        seeLaterShowsDao().deleteById(id.id)
      }
    }
  }

  suspend fun delete(id: IdTrakt) =
    database.archiveShowsDao().deleteById(id.id)

  suspend fun isArchived(id: IdTrakt) =
    database.archiveShowsDao().getById(id.id) != null
}
