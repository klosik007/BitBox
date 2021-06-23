package com.example.bitbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BitBoxActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, BitBoxFragment())
            .commit()
    }
}