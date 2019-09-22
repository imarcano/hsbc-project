package com.inbergmarcano.mycvapp.ui.basicinformation.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsSuccessEvent
import com.inbergmarcano.mycvapp.rest.models.BasicInformations
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class BasicInformationDataManager (private val resumeEndpoints: ResumeEndpoints) {

        fun getResumeBasicInformation() {
            val callback = object : Callback<BasicInformations> {
                override fun onResponse(@NonNull call: Call<BasicInformations>, @NonNull response: retrofit2.Response<BasicInformations>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetBasicInformationsSuccessEvent(response.body()!!.basicInformations))
                    } else {
                        EventBus.getDefault().post(GetBasicInformationsFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<BasicInformations>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetBasicInformationsFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getBasicInformation().enqueue(callback)
        }

}