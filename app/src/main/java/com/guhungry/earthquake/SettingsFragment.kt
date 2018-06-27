package com.guhungry.earthquake

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.content.SharedPreferences



class SettingsFragment : PreferenceFragment(), Preference.OnPreferenceChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.settings_main)
        bindPreferenceSummaryToValue(findPreference(R.string.settings_min_magnitude_key))
    }

    fun findPreference(key: Int): Preference = findPreference(getString(key))

    private fun bindPreferenceSummaryToValue(preference: Preference) {
        preference.onPreferenceChangeListener = this

        val preferences = PreferenceManager.getDefaultSharedPreferences(preference.context)
        val preferenceString = preferences.getString(preference.key, "")
        onPreferenceChange(preference, preferenceString)
    }

    // //////////////////////////
    // OnPreferenceChangeListener
    // //////////////////////////
    override fun onPreferenceChange(preference: Preference?, value: Any?): Boolean {
        preference?.summary = value.toString()
        return true
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SettingsFragment().apply {
                    arguments = Bundle()
                }
    }
}
