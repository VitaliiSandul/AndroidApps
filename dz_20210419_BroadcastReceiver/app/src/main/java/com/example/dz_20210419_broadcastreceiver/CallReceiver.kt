package com.example.dz_20210419_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        Toast.makeText(context, "CALL RECEIVED", Toast.LENGTH_LONG).show()
        Log.d("CallReceiver", "Call received")
        callReceiverListener?.updateUiCall("Call received")
    }

    companion object {
        var callReceiverListener: CallReceiverListener? = null
    }

    interface CallReceiverListener {
        fun updateUiCall(result: String?)
    }
}