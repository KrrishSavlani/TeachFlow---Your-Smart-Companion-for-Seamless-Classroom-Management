package com.Alpha.teachflow


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class subject : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediumContainer = findViewById<LinearLayout>(R.id.medium_container)
        val btnAddMedium = findViewById<Button>(R.id.btn_add_medium)

        btnAddMedium.setOnClickListener {
            addMediumField(mediumContainer)
        }
    }

    private fun addMediumField(container: LinearLayout) {
        val newEditText = EditText(this)
        newEditText.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        newEditText.hint = "Enter Medium"
        newEditText.textSize = 18f
        newEditText.setPadding(16, 16, 16, 16)

        container.addView(newEditText)
    }
}
