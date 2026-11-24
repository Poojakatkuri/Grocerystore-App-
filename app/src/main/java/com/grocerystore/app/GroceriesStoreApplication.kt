package com.grocerystore.app

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.grocerystore.app.works.RefreshDatabaseWork
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltAndroidApp
class GroceriesStoreApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    // Lets WorkManager build workers through Hilt so they can receive injected dependencies.
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        delayedInit()
    }

    private fun delayedInit() {
        applicationScope.launch {
            val repeatingRequest =
                PeriodicWorkRequestBuilder<RefreshDatabaseWork>(1, TimeUnit.DAYS).build()
            WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
                RefreshDatabaseWork.WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP, repeatingRequest
            )
        }
    }
}
