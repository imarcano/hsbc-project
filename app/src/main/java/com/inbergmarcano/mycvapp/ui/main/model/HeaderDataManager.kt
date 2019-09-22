package com.inbergmarcano.mycvapp.ui.main.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetHeaderFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetHeaderSuccessEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class HeaderDataManager (private val resumeEndpoints: ResumeEndpoints) {

        fun getResumeHeader() {
            val callback = object : Callback<Header> {
                override fun onResponse(@NonNull call: Call<Header>, @NonNull response: retrofit2.Response<Header>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetHeaderSuccessEvent(response.body()!!))
                    } else {
                        EventBus.getDefault().post(GetHeaderFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<Header>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetHeaderFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getHeader().enqueue(callback)
        }

}