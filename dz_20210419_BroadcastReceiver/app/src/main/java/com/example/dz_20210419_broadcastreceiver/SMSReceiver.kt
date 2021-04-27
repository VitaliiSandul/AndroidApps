package com.example.dz_20210419_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        Toast.makeText(context, "SMS RECEIVED", Toast.LENGTH_LONG).show()
        Log.d("SMSReceiver ", "----- SMS RECEIVED -----")

        val bundle = intent.extras
        if (bundle != null) {
            smsReceiverListener?.updateUiSms("SMS received")
            abortBroadcast()
        }
    }

    companion object {
        var smsReceiverListener: SMSReceiverListener? = null
    }

    interface SMSReceiverListener {
        fun updateUiSms(result: String?)
    }
}