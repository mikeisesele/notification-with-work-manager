package com.example.workmanagernotification

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*

class MainActivity : AppCompatActivity() {

//    implementation 'androidx.work:work-runtime-ktx:2.7.1' - add to build.gradle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onResume() {
        super.onResume()
        invokeNotification()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun invokeNotification() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiresDeviceIdle(false)
            .setRequiresBatteryNotLow(true)
            .build()

        // Create a OneTimeWorkRequest

        val oneTimeNotificationRequest: WorkRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(oneTimeNotificationRequest)

        // for working with periodic work

//        val periodicNotificationRequest: WorkRequest = PeriodicWorkRequest
//            .Builder(NotificationWorker::class.java, 15, TimeUnit.MINUTES)
//            .setConstraints(constraints)
//            .build()
//
//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//            "periodic_notification",
//            ExistingPeriodicWorkPolicy.KEEP,
//            periodicNotificationRequest as PeriodicWorkRequest
//        )
    }
}
