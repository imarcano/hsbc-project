package com.inbergmarcano.mycvapp.rest

import com.inbergmarcano.mycvapp.rest.models.Resume
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import retrofit2.Call
import retrofit2.http.GET

interface ResumeEndpoints {
    @GET("snippets/imarcano/Lr4aj8/3ec0184430a68f3772a5db1381cc67e7996f966b/files/snippet.json")
    fun getBasicInformation(): Call<Resume>
}