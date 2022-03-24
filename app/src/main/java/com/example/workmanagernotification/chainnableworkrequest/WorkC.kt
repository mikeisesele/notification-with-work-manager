package com.example.workmanagernotification.chainnableworkrequest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkC(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) { // 1

    private val TAG = "WorkC"

    override fun doWork(): Result {
        Log.e(TAG, "doWork: Work C finished")
        return Result.success()
    }
}
