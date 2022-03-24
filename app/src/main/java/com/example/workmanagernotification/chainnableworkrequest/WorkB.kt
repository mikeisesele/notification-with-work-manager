package com.example.workmanagernotification.chainnableworkrequest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkB(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) { // 1
    private val TAG = "WorkB"

    override fun doWork(): Result {
        Log.e(TAG, "doWork: Work B started ")
        return try {
            Thread.sleep(5000)
            Log.e(TAG, "doWork: work finshed")
            Result.success()
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Result.failure()
        }
    }
}
