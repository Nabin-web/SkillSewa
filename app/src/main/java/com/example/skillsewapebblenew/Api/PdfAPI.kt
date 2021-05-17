package com.example.skillsewapebblenew.Api

import com.example.skillsewapebblenew.dataClass.pdfData
import com.example.skillsewapebblenew.response.pdfResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PdfAPI {
    @POST("/insert/housedetails")
    suspend fun CreatePdfData(@Body pdfData: pdfData):Response<pdfResponse>
}