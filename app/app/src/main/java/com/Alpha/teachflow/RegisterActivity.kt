package com.Alpha.teachflow

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var btnUploadProof: Button
    private lateinit var btnRegister: Button
    private var proofDocumentUri: Uri? = null  // Stores the uploaded file URI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registerpage)

        // Initialize Views
        btnUploadProof = findViewById(R.id.btn_upload_proof)
        btnRegister = findViewById(R.id.btn_register)

        // Upload Proof Document
        btnUploadProof.setOnClickListener {
            openFileChooser()
        }

        // Register Button Click
        btnRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun openFileChooser() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, REQUEST_CODE_FILE_PICKER)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_FILE_PICKER && resultCode == Activity.RESULT_OK) {
            proofDocumentUri = data?.data
            Toast.makeText(this, "Proof document selected!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registerUser() {
        val schoolName = findViewById<EditText>(R.id.et_school_name).text.toString().trim()
        val schoolCode = findViewById<EditText>(R.id.et_school_code).text.toString().trim()

        // Simple Validation
        if (schoolName.isEmpty() || schoolCode.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Check if proof document is uploaded
        if (proofDocumentUri == null) {
            Toast.makeText(this, "Please upload proof document", Toast.LENGTH_SHORT).show()
            return
        }

        // Proceed with registration logic (API call, DB save, etc.)
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

        // Redirect to WaitingActivity
        val intent = Intent(this, WaitingActivity::class.java)
        startActivity(intent)
        finish() // Optional: Closes the current activity
    }

    companion object {
        private const val REQUEST_CODE_FILE_PICKER = 1001
    }
}
