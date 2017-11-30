package com.egco428.firebasemessage.FirebaseService

import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.egco428.firebasemessage.Config.Config

/**
 * Created by 6272user on 11/30/2017 AD.
 */
class MyFirebaseMessagingService: FirebaseMessagingService(){
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        handleNotification(remoteMessage!!.notification.body)
    }
    private fun handleNotification(body: String?){
        val pushNotification = Intent(Config.STR_PUSH)
        pushNotification.putExtra("message", body)
        LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification)
    }
}