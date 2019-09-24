package com.inbergmarcano.mycvapp.ui.experience.model

import androidx.annotation.NonNull
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.rest.events.GetExperienceFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceSuccessEvent
import com.inbergmarcano.mycvapp.rest.models.ExperienceList
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Singleton

@Singleton
class ExperienceDataManager (private val resumeEndpoints: ResumeEndpoints): ExperienceContract.DataManager {

        override fun getResumeExperience() {
            val callback = object : Callback<ExperienceList> {
                override fun onResponse(@NonNull call: Call<ExperienceList>, @NonNull response: retrofit2.Response<ExperienceList>) {
                    if (response.isSuccessful) {
                        EventBus.getDefault().post(GetExperienceSuccessEvent(response.body()!!.experiences))
                    } else {
                        EventBus.getDefault().post(GetExperienceFailureEvent(response.message()))
                    }
                }

                override fun onFailure(@NonNull call: Call<ExperienceList>, @NonNull t: Throwable) {
                    EventBus.getDefault().post(GetExperienceFailureEvent(t.localizedMessage))
                }
            }
            resumeEndpoints.getExperience().enqueue(callback)
        }

}