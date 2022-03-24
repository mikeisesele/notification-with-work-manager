package com.example.workmanagernotification.chainnableworkrequest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkA(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    private val TAG = "WorkA"

    override fun doWork(): Result {
        Log.e(TAG, "doWork: work finsihed")
        return Result.success()
    }
}
