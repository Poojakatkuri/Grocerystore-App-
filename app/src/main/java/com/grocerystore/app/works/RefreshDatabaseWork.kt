package com.grocerystore.app.works

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.grocerystore.app.domain.usecases.RefreshAppDataUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

// FLOW step 4 (fetch trigger): WorkManager runs this job once a day in the background
// (scheduled in GroceriesStoreApplication). Onboarding also triggers the same refresh on first launch.
// Hilt injects the use case through the constructor (@HiltWorker + @AssistedInject).
@HiltWorker
class RefreshDatabaseWork @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val refreshAppDataUseCase: RefreshAppDataUseCase
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        return try {
            Timber.d("Refreshing database")
            refreshAppDataUseCase(Unit)
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "RefreshDatabaseWorker"
    }
}
