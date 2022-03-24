package com.example.workmanagernotification.chainnableworkrequest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanagernotification.R

class ChainabelWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chainabel_work)
    }

    override fun onResume() {
        super.onResume()

        val oneTimeWorkRequestA = OneTimeWorkRequest.Builder(WorkA::class.java).build()
        val oneTimeWorkRequestB = OneTimeWorkRequest.Builder(WorkB::class.java).build()
        val oneTimeWorkRequestC = OneTimeWorkRequest.Builder(WorkC::class.java).build()

//        Simple Work Requests

//        WorkManager.getInstance(this)
//                .beginWith(oneTimeWorkRequestA)
//                .then(oneTimeWorkRequestB)
//                .then(oneTimeWorkRequestC)
//                .enqueue();

//        Parallel chainable Work request
        WorkManager.getInstance(this)
            .beginWith(listOf(oneTimeWorkRequestA, oneTimeWorkRequestB))
            .then(oneTimeWorkRequestC)
            .enqueue()
    }
}
