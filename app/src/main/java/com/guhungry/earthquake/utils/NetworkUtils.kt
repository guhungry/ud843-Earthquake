package com.guhungry.earthquake.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkUtils {
    companion object {
        fun hasInternetConnection(context: Context): Boolean {
            val connection = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connection.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}