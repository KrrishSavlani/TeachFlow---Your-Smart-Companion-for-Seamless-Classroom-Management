package com.Alpha.teachflow


import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.Alpha.teachflow.R

class MediumsActivity : AppCompatActivity() {

    private var mediumCount = 3  // Start from 3 since 1 & 2 are already in XML

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mediums)  // Ensure this matches your XML filename

        val addButton = findViewById<Button>(R.id.btn_add_medium)
        val nextButton = findViewById<Button>(R.id.btn_next)
        val mediumContainer = findViewById<LinearLayout>(R.id.medium_container)

        addButton.setOnClickListener {
            addNewMedium(mediumContainer)
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, SelectStdActivity::class.java)  // Open SubjectsActivity
            startActivity(intent)
        }
    }

    private fun addNewMedium(container: LinearLayout) {
        val newEditText = EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 20, 0, 0)  // Add space between EditTexts
            }
            hint = "Medium $mediumCount 🌐"  // Adding an emoji
            textSize = 20f  // Reduced size to avoid UI issues
            setBackgroundResource(R.drawable.edittext_border)  // Custom border if needed
        }

        container.addView(newEditText)
        mediumCount++
    }
}
