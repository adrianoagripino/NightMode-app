package com.adrianobr.nightmode

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.adrianobr.nightmode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appSettingPreference: SharedPreferences = getSharedPreferences("AppSettingPreference", 0)
        val sharedPreferenceEditor: SharedPreferences.Editor = appSettingPreference.edit()
        val isNightModeOn: Boolean = appSettingPreference.getBoolean("NightMode", false)

        if(isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.btnSwitch.text = "Disable Dark Mode"
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.btnSwitch.text = "Enable Dark Mode"
        }

        binding.btnSwitch.setOnClickListener {
            if(isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferenceEditor.putBoolean("NightMode", false)
                sharedPreferenceEditor.apply()

                binding.btnSwitch.text = "Enable Dark Mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferenceEditor.putBoolean("NightMode", true)
                sharedPreferenceEditor.apply()

                binding.btnSwitch.text = "Disable Dark Mode"
            }
        }
    }
}