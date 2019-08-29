package com.michaldrabik.showly2.di

import com.michaldrabik.network.di.CloudComponent
import com.michaldrabik.showly2.MainActivity
import com.michaldrabik.showly2.ui.discover.DiscoverFragment
import com.michaldrabik.storage.di.StorageComponent
import dagger.Component

@AppScope
@Component(
  dependencies = [CloudComponent::class, StorageComponent::class],
  modules = [AppModule::class]
)
interface AppComponent {
  fun inject(activity: MainActivity)

  fun inject(fragment: DiscoverFragment)
}
