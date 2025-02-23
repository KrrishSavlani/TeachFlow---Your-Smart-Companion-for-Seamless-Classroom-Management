package com.Alpha.teachflow

 import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WaitingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.waitingpage) // Link to your XML file

        val tvWaitMessage: TextView = findViewById(R.id.tv_wait_message)
        val btnCheckApproval: Button = findViewById(R.id.btn_check_approval)

        btnCheckApproval.setOnClickListener {
            //checkApprovalStatus("1") // Replace with school id
            val intent = Intent(this, MediumsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkApprovalStatus(userId: String) {
        val call = RetrofitClient.instance.checkApproval(ApprovalRequest(userId))

        call.enqueue(object : Callback<ApprovalResponse> {
            override fun onResponse(call: Call<ApprovalResponse>, response: Response<ApprovalResponse>) {
                if (response.isSuccessful) {
                    val isApproved = response.body()?.approved ?: false
                    Toast.makeText(applicationContext, "Approval: $isApproved", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Failed to get approval status", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApprovalResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
