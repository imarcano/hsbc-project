package com.inbergmarcano.mycvapp.rest

import com.inbergmarcano.mycvapp.rest.models.BasicInformationList
import com.inbergmarcano.mycvapp.rest.models.ExperienceList
import com.inbergmarcano.mycvapp.rest.models.KnowledgeList
import com.inbergmarcano.mycvapp.ui.main.model.Header
import com.inbergmarcano.mycvapp.ui.profile.model.Profile
import retrofit2.Call
import retrofit2.http.GET

interface ResumeEndpoints {
    @GET("snippets/imarcano/Lr4aj8/files/basic-informations.json")
    fun getBasicInformation(): Call<BasicInformationList>

    @GET("snippets/imarcano/qng59G/files/header.json")
    fun getHeader(): Call<Header>

    @GET("snippets/imarcano/7ng5En/files/profile.json")
    fun getProfile(): Call<Profile>

    @GET("snippets/imarcano/qng5rB/files/knowledge.json")
    fun getKnowledge(): Call<KnowledgeList>

    @GET("snippets/imarcano/qng5KA/files/experience.json")
    fun getExperience(): Call<ExperienceList>
}