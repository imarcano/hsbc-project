package com.inbergmarcano.mycvapp.ui.profile.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetProfileFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetProfileSuccessEvent
import com.inbergmarcano.mycvapp.ui.profile.presenter.ProfileContract
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class ProfileDataManager (private val resumeEndpoints: ResumeEndpoints): ProfileContract.DataManager {

        override fun getResumeProfile() {
            val callback = object : Callback<Profile> {
                override fun onResponse(@NonNull call: Call<Profile>, @NonNull response: retrofit2.Response<Profile>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetProfileSuccessEvent(response.body()!!))
                    } else {
                        EventBus.getDefault().post(GetProfileFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<Profile>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetProfileFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getProfile().enqueue(callback)
        }

}