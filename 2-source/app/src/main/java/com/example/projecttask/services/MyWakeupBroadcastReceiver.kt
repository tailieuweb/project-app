package com.example.projecttask.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyWakeupBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        print("onReceive: ${intent?.action}")
    }
}