package com.inbergmarcano.mycvapp.ui.knowledge.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsSuccessEvent
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeSuccessEvent
import com.inbergmarcano.mycvapp.rest.models.BasicInformations
import com.inbergmarcano.mycvapp.rest.models.KnowledgeList
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class KnowledgeDataManager (private val resumeEndpoints: ResumeEndpoints) {

        fun getResumeKnowledge() {
            val callback = object : Callback<KnowledgeList> {
                override fun onResponse(@NonNull call: Call<KnowledgeList>, @NonNull response: retrofit2.Response<KnowledgeList>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetKnowledgeSuccessEvent(response.body()!!.knowledge))
                    } else {
                        EventBus.getDefault().post(GetKnowledgeFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<KnowledgeList>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetKnowledgeFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getKnowledge().enqueue(callback)
        }

}