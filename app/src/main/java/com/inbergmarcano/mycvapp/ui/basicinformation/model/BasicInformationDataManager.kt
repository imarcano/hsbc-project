package com.inbergmarcano.mycvapp.ui.basicinformation.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetResumeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetResumeSuccessEvent
import com.inbergmarcano.mycvapp.rest.models.Resume
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class BasicInformationDataManager (private val resumeEndpoints: ResumeEndpoints) {

        fun getResumeBasicInformation() {
            val callback = object : Callback<Resume> {
                override fun onResponse(@NonNull call: Call<Resume>, @NonNull response: retrofit2.Response<Resume>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetResumeSuccessEvent(response.body()!!.basicInformations))
                    } else {
                        EventBus.getDefault().post(GetResumeFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<Resume>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetResumeFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getBasicInformation().enqueue(callback)
        }

}