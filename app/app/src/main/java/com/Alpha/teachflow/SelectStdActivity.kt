//here the page will come that select that do you want to
package com.Alpha.teachflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectStdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.standard)

        val btnAllStandards: Button = findViewById(R.id.btn_all_standards)
        val btnSelectStandards: Button = findViewById(R.id.btn_select_standards)

        btnAllStandards.setOnClickListener {
            // Handle the "All Standards (1-12)" button click
            val intent = Intent(this, AllStdActivity::class.java)
            startActivity(intent)
        }

        btnSelectStandards.setOnClickListener {
            // Handle the "Select Specific Standards" button click
            val intent = Intent(this, AllStdActivity::class.java)
            startActivity(intent)
        }
    }
}
