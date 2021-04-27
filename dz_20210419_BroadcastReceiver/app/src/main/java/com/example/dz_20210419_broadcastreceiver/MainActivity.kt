package com.example.dz_20210419_broadcastreceiver

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), SMSReceiver.SMSReceiverListener,
        BatteryLevelReceiver.BatteryLevelReceiverListener, CallReceiver.CallReceiverListener {

    val batteryReceiver = BatteryLevelReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestSmsPermission()
        requestCallPermission()
        registerReceiver(SMSReceiver(), IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    }

    override fun onResume() {
        super.onResume()
        SMSReceiver.smsReceiverListener = this

        val ifilter = IntentFilter()
        ifilter.addAction(Intent.ACTION_BATTERY_LOW)
        ifilter.addAction(Intent.ACTION_BATTERY_OKAY)
        registerReceiver(batteryReceiver, ifilter)
        BatteryLevelReceiver.batteryLevelReceiverListener = this

        CallReceiver.callReceiverListener = this
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryReceiver)
    }

    private fun requestSmsPermission() {
        val readSms: String = Manifest.permission.READ_SMS
        val receiveSms: String = Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, readSms) + ContextCompat.checkSelfPermission(this, receiveSms)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(readSms, receiveSms), 1)
        } else {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            Log.d("", "Permission granted")
        }
    }

    private fun requestCallPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.READ_PHONE_STATE),
                    1)

            Log.d("CALL Permission", "----- added -----")
        }
    }

    override fun updateUiBatteryLevel(result: String?) {
        val textView1 = findViewById<TextView>(R.id.textView1)
        textView1.text = result
    }

    override fun updateUiSms(result: String?) {
        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text = result
    }

    override fun updateUiCall(result: String?) {
        val textView3 = findViewById<TextView>(R.id.textView3)
        textView3.text = result
    }
}