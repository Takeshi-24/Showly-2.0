@file:Suppress("DEPRECATION")

package com.michaldrabik.storage.database.dao.converters

import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.jakewharton.threetenabp.AndroidThreeTen
import com.michaldrabik.storage.database.converters.DateConverter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime

@RunWith(AndroidJUnit4::class)
class DateConverterTest {

  private val SUT by lazy { DateConverter() }

  @Before
  fun setUp() {
    AndroidThreeTen.init(ApplicationProvider.getApplicationContext())
  }

  @Test
  fun shouldConvertTimestampToDate() {
    val date = SUT.stringToDate(1573120000000) // Thu Nov 07 2019 09:46:40
    assertThat(date).isEqualTo(ZonedDateTime.of(2019, 11, 7, 9, 46, 40, 0, ZoneId.of("UTC")))
  }

  @Test
  fun shouldConvertDateToTimestamp() {
    val timestamp = SUT.dateToString(ZonedDateTime.of(2019, 11, 7, 9, 46, 40, 0, ZoneId.of("UTC")))
    assertThat(timestamp).isEqualTo(1573120000000)
  }
}
