package com.example.workmanagernotification

import android.app.NotificationManager
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        invokeNotification()
        return Result.success()
    }

    private fun invokeNotification() {
        // notification manager
        val mNotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        NotificationHelper.createNotification(applicationContext, mNotificationManager)
    }
}