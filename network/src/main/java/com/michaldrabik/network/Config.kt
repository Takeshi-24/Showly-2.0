package com.michaldrabik.network

object Config {
  const val TRAKT_VERSION = "2"
  const val TRAKT_BASE_URL = "https://api.trakt.tv/"
  const val TRAKT_CLIENT_ID = BuildConfig.TRAKT_CLIENT_ID
  const val TRAKT_CLIENT_SECRET = BuildConfig.TRAKT_CLIENT_SECRET
  const val TRAKT_REDIRECT_URL = "showly2://trakt"
  const val TRAKT_AUTHORIZE_URL = "https://trakt.tv/oauth/authorize?response_type=code&client_id=$TRAKT_CLIENT_ID&redirect_uri=$TRAKT_REDIRECT_URL"

  const val TRAKT_POPULAR_SHOWS_LIMIT = 60
  const val TRAKT_TRENDING_SHOWS_LIMIT = 298
  const val TRAKT_ANTICIPATED_SHOWS_LIMIT = 40
  const val TRAKT_RELATED_SHOWS_LIMIT = 15
  const val TRAKT_SEARCH_LIMIT = 50

  const val TVDB_BASE_URL = "https://api.thetvdb.com/"
  const val TVDB_API_KEY = BuildConfig.TVDB_API_KEY
}
