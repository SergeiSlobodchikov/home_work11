package com.example.home_work11

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.home_work11.databinding.ActivityMainBinding

private lateinit var repository: Repository


private const val PREFERENCE_NAME = "prefs_name"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        repository = Repository(this)

        binding.saveButton.setOnClickListener {
            repository.saveText(binding.editText.text.toString())
            updateTextView()
        }

        binding.clearButton.setOnClickListener {
            repository.clearText()
            updateTextView()
        }

        updateTextView()
    }

    private fun updateTextView() {
        binding.textView.text = repository.getText()
    }

}

