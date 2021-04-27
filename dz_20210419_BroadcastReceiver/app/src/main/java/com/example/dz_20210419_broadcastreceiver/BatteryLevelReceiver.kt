package com.example.dz_20210419_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BatteryLevelReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent?.getAction().equals(Intent.ACTION_BATTERY_LOW)){
            Toast.makeText(context, "The device need to charge. Battery is low.", Toast.LENGTH_SHORT).show()
            Log.d("BatteryLevelReceiver", "----- Battery LOW -----")
            batteryLevelReceiverListener?.updateUiBatteryLevel("Battery LOW")
        }
        else{
            Toast.makeText(context, "The battery is Okey.", Toast.LENGTH_SHORT).show()
            Log.d("BatteryLevelReceiver", "----- Battery HIGH -----")
            batteryLevelReceiverListener?.updateUiBatteryLevel("Battery HIGH")
        }
    }

    companion object {
        var batteryLevelReceiverListener: BatteryLevelReceiverListener? = null
    }

    interface BatteryLevelReceiverListener {
        fun updateUiBatteryLevel(result: String?)
    }
}