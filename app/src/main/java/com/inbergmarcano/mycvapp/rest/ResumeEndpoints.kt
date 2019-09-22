package com.inbergmarcano.mycvapp.rest

import com.inbergmarcano.mycvapp.rest.models.BasicInformations
import com.inbergmarcano.mycvapp.ui.main.model.Header
import com.inbergmarcano.mycvapp.ui.profile.model.Profile
import retrofit2.Call
import retrofit2.http.GET

interface ResumeEndpoints {
    @GET("snippets/imarcano/Lr4aj8/files/basic-informations.json")
    fun getBasicInformation(): Call<BasicInformations>

    @GET("snippets/imarcano/qng59G/files/header.json")
    fun getHeader(): Call<Header>

    @GET("snippets/imarcano/7ng5En/files/profile.json")
    fun getProfile(): Call<Profile>
}