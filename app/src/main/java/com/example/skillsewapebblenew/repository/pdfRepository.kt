package com.example.skillsewapebblenew.repository

import com.example.skillsewapebblenew.Api.PdfAPI
import com.example.skillsewapebblenew.Api.ServiceBuilder
import com.example.skillsewapebblenew.Api.pdfApiRequest
import com.example.skillsewapebblenew.dataClass.pdfData
import com.example.skillsewapebblenew.response.pdfResponse

class pdfRepository: pdfApiRequest() {
    val pdfapi = ServiceBuilder.buildService(PdfAPI::class.java)

    suspend fun insertPdfData(pdfData: pdfData):pdfResponse{
        return apiRequest {
            pdfapi.CreatePdfData(pdfData)
        }
    }
}