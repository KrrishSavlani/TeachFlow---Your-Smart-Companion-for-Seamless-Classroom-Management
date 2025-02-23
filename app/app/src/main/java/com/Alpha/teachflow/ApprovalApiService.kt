package com.Alpha.teachflow

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class ApprovalRequest(val userId: String)
data class ApprovalResponse(val approved: Boolean)

interface ApprovalApiService {
    @POST("checkApproval") // Change this to your actual endpoint
    fun checkApproval(@Body request: ApprovalRequest): Call<ApprovalResponse>
}

