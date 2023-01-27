package com.example.ranfomfactnumbers.peridicworker

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

interface WorkManagerWrapper {

    fun enqueue()

    class Base(context: Context) : WorkManagerWrapper {
        private val workManager = WorkManager.getInstance(context)

        override fun enqueue() {
            val constraints = Constraints.Builder()
                .setRequiresStorageNotLow(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
            val request = PeriodicWorkRequestBuilder<PeriodicRandomWorker>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
            workManager.enqueueUniquePeriodicWork(WORK_NAME, ExistingPeriodicWorkPolicy.KEEP, request)
        }

        companion object {
            private const val WORK_NAME = "random number work"
        }

    }

}