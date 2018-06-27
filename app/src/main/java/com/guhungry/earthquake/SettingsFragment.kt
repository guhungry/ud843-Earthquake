package com.guhungry.earthquake

import android.os.Bundle
import android.preference.PreferenceFragment

class SettingsFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.settings_main)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SettingsFragment().apply {
                    arguments = Bundle()
                }
    }
}
