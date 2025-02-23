package com.Alpha.teachflow

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AllStdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_std_layout)

        // Loop through standards 1 to 12
        for (i in 1..12) {
            val buttonId = resources.getIdentifier("standard$i", "id", packageName)
            val button = findViewById<View>(buttonId)

            button?.setOnClickListener {
                openStandardDetails(i)
            }
        }
    }

    private fun openStandardDetails(standard: Int) {
        val intent = Intent(this, subject::class.java)
        intent.putExtra("STANDARD_NUMBER", standard)
        startActivity(intent)
    }
}
